package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.exception.MiembroNoPostuladoException;
import dds.grupo3.clases.exception.MiembroNoVinculadoException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.fachada.FachadaPosta;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.Postulacion;
import dds.grupo3.clases.readers.MedicionCSV;
import dds.grupo3.clases.readers.MedicionesReader;
import dds.grupo3.clases.readers.ParametrosReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Organizacion {
	private String razonSocial;
	private TipoOrg tipo;
	private Clasificacion clasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();
	private List<Postulacion> postulados;
	private MedicionesReader reader;


	public void setMediciones(List<Medible> mediciones) {
		this.mediciones = mediciones;
	}

	

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

	// Postulaciones y agregar miembros


	//Agregar postulacion a la lista de postulados
	public void nuevoPostulado(Miembro miembro, Sector sector){this.postulados.add(new Postulacion(miembro,sector));}

	//lee una por una las postulaciones y elige si aceptarla o no
	public void aceptarPostulacionConMiembro(Miembro miembro) {
		for (Postulacion postulado : postulados) {
			this.agregarMiembroSector(postulado.getSector(),postulado.getMiembro());
		}
	}
	public void agregarMiembroSector(Sector sector,Miembro miembro) throws SectorNoPerteneceOrgException {
		if (!sectores.contains(sector)) {
			throw new SectorNoPerteneceOrgException();
		}
		else{
			sector.agregarMiembro(miembro);
		}
	}

	//De vuelve todos los miembros por sector
	public List<Miembro> miembrosOrg(){
		return sectores.stream().flatMap(s -> s.getMiembros().stream()).collect(Collectors.toList());
	}
}
