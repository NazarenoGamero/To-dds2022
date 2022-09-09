package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.exception.MiembroYaPerteneceOrgException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Organizacion {
  private Long id ;
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
  public Organizacion(String razonSocial, TipoOrg tipo, List<Sector> sectores,
                      Clasificacion clasificacion) {
    this.razonSocial = razonSocial;
    this.tipo = tipo;
    this.sectores = sectores;
    this.clasificacion = clasificacion;
    this.postulados = new ArrayList<Postulacion>();
    this.mediciones = new ArrayList<Medible>();
  }

  public Organizacion() {
    this.razonSocial = "AFIP";
    this.tipo = new TipoOrg("Gubernamental");
    this.sectores = new ArrayList<Sector>();
    this.agregarSector(new Sector("RRHH"));
    this.clasificacion = new Clasificacion("Ministerio");
    this.postulados = new ArrayList<Postulacion>();
    this.mediciones = new ArrayList<Medible>();
  }
  public Organizacion(String razonSocial) {
    this.razonSocial = razonSocial;
    this.sectores = new ArrayList<Sector>();
    this.postulados = new ArrayList<Postulacion>();
    this.mediciones = new ArrayList<Medible>();
  }

  /*------------------------------------------------
   * Calculo de huella
   * ----------------------------------------------
   */
  //Huella Completa : 123123
  //	Huella de Combustion Fija: 1123
  // 
  //
  //
  public String calcularHuellaDeCarbonoST() {
    float total = 0;
    String mensajeCompleto = "";
    
    //Obtengo el Total de todas las mediciones de la org
    for (Medible unMedible : this.getMediciones()) {
      total = total + unMedible.obtenerHuella();
    }
    
    //Obtengo un map con los tipos de medicion y sus medibles
    Map<String, List<Medible>> tiposYMedibles=obtenerTotalPorTipo();
    
    String detalleDeTipos = serializarString(tiposYMedibles);
    
    mensajeCompleto = "El total emitido por la organizacion es: "+String.valueOf(total) +"\n"+detalleDeTipos;
    return mensajeCompleto;
  }

  private String serializarString(Map<String, List<Medible>> tiposYMedibles) {
	  String detalleDeTipos = "";
	  for(Map.Entry<String,List<Medible>> unMap : tiposYMedibles.entrySet()) {
		  //Para cada lista de medibles. Mapeo para obtener el valor, los sumo y así obtengo el total del tipo
	    	float totalDelTipo = (float) unMap.getValue().stream().mapToDouble(unMedible -> unMedible.obtenerHuella()).sum();
	    	//El total de Combustion Fija es: 12.3
	    	String detalleDeUnTipo = "El total de " + unMap.getKey() + " es: "+ String.valueOf(totalDelTipo);
	    	detalleDeTipos = detalleDeTipos + detalleDeUnTipo + "\n";
	  }
	return detalleDeTipos;
}

private Map<String, List<Medible>> obtenerTotalPorTipo() {
	 return this.getMediciones().stream().collect(Collectors.groupingBy(medicion -> medicion.getTipoDeMedicion().getActividad().getNombre()));
	
}

public String calcularHuellaDeCarbonoT() {
    String mensajeOrganizacion = this.calcularHuellaDeCarbonoST();
    
    mensajeOrganizacion = mensajeOrganizacion + this.huellaSectores();
    
    return mensajeOrganizacion;
  }

public String huellaSectores() {
	String mensajeSectoresOrganizacion="";
	for(Sector unSector : this.getSectores()) {
		mensajeSectoresOrganizacion = mensajeSectoresOrganizacion + unSector.calcularHuellaMiembros();
	}
	return mensajeSectoresOrganizacion;
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
  public void nuevoPostulado(Miembro miembro, Sector sector) {
    this.postulados.add(new Postulacion(miembro, sector));
  }

  //lee una por una las postulaciones y elige si aceptarla o no
  public void aceptarPostulacion() {
    for (Postulacion postulado : this.postulados) {
      this.agregarMiembroSector(postulado.getSector(), postulado.getMiembro());
    }
  }

  private void agregarMiembroSector(Sector sector, Miembro miembro)
      throws SectorNoPerteneceOrgException, MiembroYaPerteneceOrgException {
    if (miembrosOrg().contains(miembro)) {//Si el miembro ya esta en la org
      throw new MiembroYaPerteneceOrgException();
    } else if (!sectores.contains(sector)) {//Si el sector no esta en la org
      throw new SectorNoPerteneceOrgException();
    } else {//Si el miembro no esta en la org y el sector está en la misma
      sector.agregarMiembro(miembro);
      //miembro.nuevoEmpleo(this,sector); TODO descomentar
    }
  }

  //De vuelve todos los miembros por sector
  public List<Miembro> miembrosOrg() {
    return sectores.stream().flatMap(s -> s.getMiembros().stream()).collect(Collectors.toList());
  }

  public List<Medible> getMediciones() {
    return mediciones;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
