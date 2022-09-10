package dds.grupo3.clases.miembro;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.trayectos.Trayecto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="miembro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Miembro {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  @Transient
  private String nombre;
  @Transient
  private String apellido;
  @Transient
  private TipoDocEnum tipoDoc;
  @Transient
  private Long nroDoc;
  @Transient
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

  public float calcularHU() {
    return trayectos.stream().mapToInt(t -> (int) t.calcularHU()).sum();
  }
  
  //TODO cambiar nombre por algo mas descriptivo
  public String obtenerHU() {
	  float valorHuella = this.calcularHU();
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


  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id=id;
  }
}
