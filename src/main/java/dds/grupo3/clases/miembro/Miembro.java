package dds.grupo3.clases.miembro;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.trayectos.Trayecto;
import java.util.List;

public class Miembro {
  private String nombre;
  private String apellido;
  private TipoDocEnum tipoDoc;
  private Long nroDoc;
  private List<Trayecto> trayectos;
  //private Set<Empleo> empleos; //TODO descomentar

  // Constructor
	/*public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, int nroDoc, Set<Empleo> empleos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;//TODO descomentar
		this.empleos = empleos;
	}*/

  public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, Long nroDoc) {
    super();
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipoDoc = tipoDoc;
    this.nroDoc = nroDoc;
  }

  public void setUnTrayecto(List<Trayecto> unTrayecto) {
    this.trayectos = unTrayecto;
  }

  public void agregarUnTrayecto(Trayecto unTrayecto) {
    trayectos.add(unTrayecto);
  }

  public String calcularHU() {
    float valorHuella = trayectos.stream().mapToInt(t -> (int) t.calcularHU()).sum();
    return "-"+nombre+" "+apellido+": "+valorHuella+"\n";
  }

  /*
    public List<int> calcularHUPorcentual(){
      //empleos
      //TODO tenemos que definir como hace el miembro para saber el HU de la org
      return null;
    }
  */
  public void postularme(Organizacion organizacion, Sector sector) {
    organizacion.nuevoPostulado(this, sector);
  }

  /*
    public void nuevoEmpleo(Organizacion organizacion, Sector sector) {
      empleos.add(new Empleo(organizacion,sector));//TODO descomentar
    }
  */
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public TipoDocEnum getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(TipoDocEnum tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  public Long getNroDoc() {
    return nroDoc;
  }

  public void setNroDoc(Long nroDoc) {
    this.nroDoc = nroDoc;
  }


}
