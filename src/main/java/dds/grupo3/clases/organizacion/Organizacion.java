package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.*;
import dds.grupo3.clases.Exception.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
	private String razonSocial;
	private Tipo tipo;
	private List<Sector> sectores;
	private ClasificacionConSectores clasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();
	private List<Miembro> postulados;
	private List<Miembro> miembrosVinculados;
	private MedicionesReader reader;

	public Organizacion(String razonSocial, Tipo tipo, List<Sector> unSector, List<Sector> sectoresObligatorios, Clasificacion unaClasificaion) throws OrganizacionInvalida {

			this.razonSocial = razonSocial;
			this.tipo = tipo;
			this.clasificacion = clasificacion;
			if(this.organizacionEsValida()){
				this.sectores = new ArrayList<Sector>();
			}
			else throw new OrganizacionInvalida();
			this.postulados= new ArrayList<>();
			this.miembrosVinculados= new ArrayList<>();
			this.reader= new MedicionCSV();
	}

	public boolean organizacionEsValida(){
		return this.clasificacion.sectoresObligatorios.contains(sectores);
	}
	
	public void cargarMediciones(String path){
		mediciones.addAll(reader.leerArchivoMediciones(path));
	}

	/* agregar estas funciones mas tarde */
	public void aceptarVinculacionConMiembro(Miembro miembro) {
		if(postulados.contains(miembro)) {
			postulados.remove(miembro);
			miembrosVinculados.add(miembro);
		}
		else throw new MiembroNoPostuladoException("Miembro No Postulado");
	}

	public void agregarMiembroSector(Sector sector,Miembro miembro) throws SectorNoPerteneceOrgException {
		if (!sectores.contains(sector)) {
			throw new SectorNoPerteneceOrgException("El sector no pertenece a la organizacion");
		}
		if(!miembrosVinculados.contains(miembro)){
			throw new MiembroNoVinculadoException("El miembro no esta vinculado.");
		}
		else{
			sector.agregarMiembro(miembro);
		}
	}

	public float calcularHuellaDeCarbonoST(List<Medible> unasMediciones) throws IOException {
        FachadaPosta unaFachada = new FachadaPosta();
        ParametrosReader reader = new ParametrosReader();
        String path = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";
        unaFachada.cargarParametros(reader.leerParametros(path));
        return unaFachada.obtenerHU(unasMediciones);
    }
	// añade un postulado a la lista
	public void nuevoPostulado(Miembro miembro){this.postulados.add(miembro);}

	public void agregarSector(Sector sector) throws YaPerteneceOrgException {

		if (sector.getOrganizacion() != null) {
			throw new YaPerteneceOrgException();
		} else {
			this.sectores.add(sector);
			sector.setOrganizacion(this);
			
		}

	}
}
