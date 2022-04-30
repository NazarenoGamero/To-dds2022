package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.*;
import dds.grupo3.clases.Exception.YaPerteneceOrgException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;

public class Organizacion {
	private String razonSocial;
	private Tipo tipo;
	private List<Sector> unSector = new ArrayList<Sector>();
	private Clasificacion unaClasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();
	private List<Miembro> postulados;
	private List<Miembro> miembrosVinculados;
	private MedicionesReader reader;

	public Organizacion(String razonSocial, Tipo tipo, List<Sector> unSector, Clasificacion unaClasificaion) {
		this.razonSocial = razonSocial;
		this.tipo = tipo;
		this.unSector = unSector;
		this.unaClasificacion = unaClasificacion;
		this.postulados= new ArrayList<>();
		this.miembrosVinculados= new ArrayList<>();
		this.reader= new MedicionCSV();
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

	public float calcularHuellaDeCarbonoST(List<Medible> unasMediciones) throws IOException {
		FachadaPosta unaFachada = new FachadaPosta();
		ParametrosReader reader = new ParametrosReader();
		String path = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";
		unaFachada.cargarParametros(reader.leerParametros(path));
		return unaFachada.obtenerHU(unasMediciones);
	}

	/*
	 * public void getMiembros(){ return unSector.getMiembros() }
	 */
	public void agregarSector(Sector sector){
		
		if (sector.getOrganizacion() != null) {
			throw new YaPerteneceOrgException();
		} else {
			this.unSector.add(sector);
			sector.setOrganizacion(this);
			
		}
		
	}
}
