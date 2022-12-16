package dds.grupo3.clases.trayectos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TRAYECTO")
public class Trayecto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long idTrayecto;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="trayecto_id")
	@OrderColumn
  private List<Tramo> tramos;


  public float calcularHU() {
	  return (float) tramos.stream().mapToDouble(t-> t.calculaHU()).sum();
	  
  }
}
