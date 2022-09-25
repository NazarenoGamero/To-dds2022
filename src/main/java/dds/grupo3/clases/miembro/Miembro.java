package dds.grupo3.clases.miembro;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.grupo3.api.dto.request.MiembroDTO;
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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(name="NOMBRE")
  private String nombre;
  @Column(name="APELLIDO")
  private String apellido;
  @Column(name="TIPO_DOC")
  private TipoDocEnum tipoDoc;
  @Column(name="DOCUMENTO")
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

  public void postularme(Organizacion organizacion, Sector sector) {
    organizacion.nuevoPostulado(this, sector);
  }
  
  public Miembro(MiembroDTO dto) {
	  this.nombre = dto.getNombre();
	    this.apellido = dto.getApellido();
	    this.tipoDoc = TipoDocEnum.valueOf(dto.getTipoDoc());
	    this.nroDoc = dto.getNroDoc();
  }
}
