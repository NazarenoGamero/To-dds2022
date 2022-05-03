package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.*;
import dds.grupo3.clases.Exception.MiembroNoPostuladoException;
import dds.grupo3.clases.Exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.Exception.YaPerteneceOrgException;
import dds.grupo3.clases.Exception.MiembroNoVinculadoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
	private String razonSocial;
	private Tipo tipo;
	private List<Sector> sectores;
	private Clasificacion clasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();
	private List<Miembro> postulados;
	private List<Miembro> miembrosVinculados;
	private MedicionesReader reader;

	public Organizacion(String razonSocial, Tipo tipo, List<Sector> unSector, Clasificacion unaClasificaion) {
		this.razonSocial = razonSocial;
		this.tipo = tipo;
		this.sectores = new ArrayList<Sector>();
		this.clasificacion = clasificacion;
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

	public float calcularHuellaDeCarbonoST(String path) throws IOException {
		FachadaPosta unaFachada = new FachadaPosta();
		MedicionesReader reader= new MedicionCSV();
		return unaFachada.obtenerHU(reader.leerArchivoMediciones(path));
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
