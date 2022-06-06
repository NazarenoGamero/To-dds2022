package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.exception.MiembroYaPerteneceOrgException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Organizacion {
	private String razonSocial;
	private TipoOrg tipo;
	private Clasificacion clasificacion;
	private List<Medible> mediciones;
	private List<Postulacion> postulados;
	private List<Sector> sectores;

	/*------------------------------------------------
	 * Constructores
	 * ----------------------------------------------
	 */
	public Organizacion() {
		this.razonSocial = "AFIP";
		this.tipo = new TipoOrg("Gubernamental");
		this.sectores = new ArrayList<Sector>();
		this.agregarSector(new Sector("RRHH"));
		this.clasificacion = new Clasificacion("Ministerio");
		this.postulados = new ArrayList<Postulacion>();
		this.mediciones =  new ArrayList<Medible>();
	}

	public Organizacion(String razonSocial) {
		this.razonSocial = razonSocial;
		this.sectores = new ArrayList<Sector>();
		this.postulados = new ArrayList<Postulacion>();
		this.mediciones =  new ArrayList<Medible>();
	}
	
	public Organizacion(String razonSocial, TipoOrg tipo, List<Sector> unSector, Clasificacion clasificacion) {
		this.razonSocial = razonSocial;
		this.tipo = tipo;
		this.sectores = new ArrayList<Sector>();
		this.clasificacion = clasificacion;
		this.postulados = new ArrayList<Postulacion>();
		this.mediciones =  new ArrayList<Medible>();
	}


	/*------------------------------------------------
	 * Calculo de huella
	 * ----------------------------------------------
	 */

	public float calcularHuellaDeCarbonoST()  {
		float total = 0;
		for(Medible unMedible : this.getMediciones()) {
			total = total + unMedible.obtenerHuella();
		}
		return total;
    }
	public float calcularHuellaDeCarbonoT(){
		return miembrosOrg().stream().mapToInt(m -> m.calcularHU()).sum();
	}
	// añade un postulado a la lista
	//TODO agregar calculo de medibles + trayectos (Composite porque dice naza)
	//TODO agregar calculo para las periodicidades (Uno para Mensual y otro Anual)
	// 		Duda, donde se filtraría esto, pensar...

	/*------------------------------------------------
	 * Agregar sector y postulacion de miembros
	 * ----------------------------------------------
	 */
	
	public void agregarSector(Sector sector) throws YaPerteneceOrgException {
		if (sector.getOrganizacion() != null) {
			throw new YaPerteneceOrgException();
		} else {
			this.sectores.add(sector);
			sector.setOrganizacion(this);
		}
	}

	// Postulaciones y agregar miembros

	//Agregar postulacion a la lista de postulados
	public void nuevoPostulado(Miembro miembro, Sector sector){
		this.postulados.add(new Postulacion(miembro,sector));
	}

	//lee una por una las postulaciones y elige si aceptarla o no
	public void aceptarPostulacion() {
		for (Postulacion postulado : this.postulados) {
			this.agregarMiembroSector(postulado.getSector(),postulado.getMiembro());
		}
	}

	public void agregarMiembroSector(Sector sector,Miembro miembro) throws SectorNoPerteneceOrgException, MiembroYaPerteneceOrgException {
		if(miembrosOrg().contains(miembro)) {//Si el miembro ya esta en la org
			throw new MiembroYaPerteneceOrgException();
		}
		else if(!sectores.contains(sector)) {//Si el sector no esta en la org
			throw new SectorNoPerteneceOrgException();
		}
		else{//Si el miembro no esta en la org y el sector está en la misma
			sector.agregarMiembro(miembro);
			miembro.nuevoEmpleo(this,sector);
		}
	}

	//De vuelve todos los miembros por sector
	public List<Miembro> miembrosOrg(){
		return sectores.stream().flatMap(s -> s.getMiembros().stream()).collect(Collectors.toList());
	}
	
	public List<Medible> getMediciones() {
		return mediciones;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public TipoOrg getTipo() {
		return tipo;
	}

	public void setTipo(TipoOrg tipo) {
		this.tipo = tipo;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public List<Postulacion> getPostulados() {
		return postulados;
	}

	public void setPostulados(ArrayList<Postulacion> postulados) {
		this.postulados = postulados;
	}


	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	
	public void setMediciones(List<Medible> mediciones) {
		this.mediciones = mediciones;
	}
}
