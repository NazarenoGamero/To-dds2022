package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.exception.MiembroNoPostuladoException;
import dds.grupo3.clases.exception.MiembroNoVinculadoException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.fachada.FachadaPosta;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.readers.MedicionCSV;
import dds.grupo3.clases.readers.MedicionesReader;
import dds.grupo3.clases.readers.ParametrosReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
	private String razonSocial;
	private TipoOrg tipo;



	public void setMediciones(List<Medible> mediciones) {
		this.mediciones = mediciones;
	}

	private Clasificacion clasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();
	private List<Miembro> postulados;
	private List<Miembro> miembrosVinculados;
	private MedicionesReader reader;

	public Organizacion(String razonSocial, TipoOrg tipo, List<Sector> unSector, Clasificacion clasificacion) {
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
		else throw new MiembroNoPostuladoException();
	}

	public void agregarMiembroSector(Sector sector,Miembro miembro) throws SectorNoPerteneceOrgException {
		if (!sectores.contains(sector)) {
			throw new SectorNoPerteneceOrgException();
		}
		if(!miembrosVinculados.contains(miembro)){
			throw new MiembroNoVinculadoException();
		}
		else{
			sector.agregarMiembro(miembro);
		}
	}

	public float calcularHuellaDeCarbonoST()  {
		List<Medible> unasMediciones = this.getMediciones(); // test: 1ro hacer el addAll mediciones
		return (float) unasMediciones.stream().mapToDouble(unaMedicion -> this.obtenerFactorPorMedicion(unaMedicion)).sum();
		/*
        FachadaPosta unaFachada = new FachadaPosta();
        ParametrosReader reader = new ParametrosReader();
        String path = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";
        unaFachada.cargarParametros(reader.leerParametros(path));
        return unaFachada.obtenerHU(unasMediciones);

		 */
    }
	public float obtenerFactorPorMedicion(Medible unaMedicion){
		return unaMedicion.factorCorrespondienteAvalorMedible() * unaMedicion.getValor();
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
	
	private List<Sector> sectores;
	public List<Medible> getMediciones() {
		return mediciones;
	}
}
