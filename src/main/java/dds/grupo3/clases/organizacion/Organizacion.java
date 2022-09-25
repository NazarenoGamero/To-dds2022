package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.clases.exception.MiembroYaPerteneceOrgException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Organizacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizacion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	@Embedded
	private TipoOrg tipo;
	@Embedded
	private Clasificacion clasificacion;
	@ManyToMany
	private List<Medible> mediciones;
	@Transient
	private List<Postulacion> postulados;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Sector> sectores;
//TODO: MUY IMPORTANTE ESTE CASCADE de otra forma al intentar guardar el sector habrá error porque se hace referencia
	//a algo que no existe en la DB

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
	 return this.getMediciones().stream().collect(Collectors.groupingBy(medicion -> medicion.getTipoDeMedicion().getTipoDeactividad().getNombre()));
	
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
    this.postulados.add(new Postulacion(sector, miembro));
  }

  //lee una por una las postulaciones y elige si aceptarla o no
  public void aceptarPostulacion() {
    for (Postulacion postulado : this.postulados) {
      this.agregarMiembroSector(postulado.getSector(), postulado.getMiembro());
    }
  }

  public void agregarMiembroSector(Sector sector, Miembro miembro)
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
  
  
  //Constructor personalizado para OrganizacionService
  public Organizacion(OrganizacionDTO org) {
	  clasificacion = org.getClasificacion();
	  mediciones = (new ArrayList<Medible>());
	  postulados = (new ArrayList<Postulacion>());
	  razonSocial = (org.getRazonSocial());
	  sectores = (org.getSectores());
	  tipo=(org.getTipo());
	  for(Sector sector : org.getSectores()) {
		  sector.setOrganizacion(this);
	  }
  }
}