package dds.grupo3.clases.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dds.grupo3.clases.exception.NoSeEncontroClasifException;
import dds.grupo3.clases.exception.NoSeEncontroTipoException;
import dds.grupo3.clases.exception.NoSePudoCrearOrgException;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.organizacion.BuilderOrg;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;

public class OrganizacionJSON {
	private Object obj;

	public OrganizacionJSON() {
		super();
	}
	
	public Organizacion leerJSON(String path, BuilderOrg builder) throws NoSePudoCrearOrgException, FileNotFoundException, NoSeEncontroTipoException, NoSeEncontroClasifException {
		
		//Preparo el parser para leer el JSON
		//Como el JSONObject tiene ciertos errores que puede dar, les hacemos catch
            obj = new FileReader(path);
            JSONObject jsonObject =  (JSONObject) obj;
            //Comienzo a leer la organizacion
            String razonSocial = (String) jsonObject.get("razonSocial");
            Organizacion org = new Organizacion(razonSocial);
            
            String tipo = (String) jsonObject.get("tipo");
            	org.setTipo(builder.buscarTipo(tipo)); 

            //Itero entre los distintos sectores y los asigno a la org
            JSONArray sectores = (JSONArray) jsonObject.get("sectores");
            org.setSectores(this.leerSectores(sectores,org));
            
            org.setClasificacion(builder.buscarClasificacion((String) jsonObject.get("clasificacion")));
            
            return org;
        
		
		
	}
	
	private List<Sector> leerSectores(JSONArray jsonSectores, Organizacion unaOrg) {
		List<Sector> listaSectores = new ArrayList<Sector>();
		for(Object sectorJSON : jsonSectores) {
			//Creo el sector con su nombre
			JSONObject sectorJSONObject = (JSONObject) sectorJSON;
			String nombre = (String) sectorJSONObject.get("nombre");
			Sector nuevoSector = new Sector(nombre);
			nuevoSector.setOrganizacion(unaOrg);
			
			//Itero entre los distintos miembros del sector y los agrego al mismo
			JSONArray miembros = (JSONArray) sectorJSONObject.get("miembros");
            nuevoSector.setMiembros(this.leerMiembros(miembros));
			
			//Agrego el sector a la lista
			listaSectores.add(nuevoSector);
		}
		
		return listaSectores;
	}

	private List<Miembro> leerMiembros(JSONArray miembros){
		List<Miembro> listaMiembros = new ArrayList<Miembro>();
		for(Object unMiembro : miembros) {
			JSONObject unMiembroJSON = (JSONObject) unMiembro;
			Miembro nuevoMiembro = new Miembro(
					(String)unMiembroJSON.get("nombre"),
					(String)unMiembroJSON.get("apellido"),
					TipoDocEnum.valueOf((String) unMiembroJSON.get("tipoDoc")),
					//this.elegirTipoDoc(unMiembroJSON.get("tipoDoc")),
					(int)unMiembroJSON.get("nroDoc"));
			
			listaMiembros.add(nuevoMiembro);
		}
		
		
		return listaMiembros;
	}
}	
	
	/* EJEMPLO DE JSON A TENER EN CUENTA
{
	"razonSocial":"Arcor",
	"tipo":"Empresa",
	"sectores":[
		{
			"nombre":"RRHH",
			"miembros":[
				{
					"nombre":"pablito",
					"apellido":"suarez",
					"tipoDoc":"DNI"
					"nroDoc":41835967,
				}
				{
					"nombre":"agustin",
					"apellido":"delgado",
					"tipoDoc":"DNI"
					"nroDoc":15448736,
				}
			]
		}
	]
	"clasificacion":"Empresa del sector secundario"
}
	 */

