package dds.grupo3.clases.trayectos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.trayectos.transporte.Transporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramo")
public class Tramo {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long idTramo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "transporte")
  private Transporte transporte;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "punto_inicio_id")
  private Punto puntoInicio;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "punto_fin_id")
  private Punto puntoDeLlegada;
	@Column(name="distancia")
  private long distancia;
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonBackReference
  private Set<Miembro> miembros;

  public float calculaHU() {
    return transporte.huPorDistancia(distancia);
  }
  
  //Se divide en HU por cada miembro para no contar dos veces el HU
  public float calculaHUPorMiembro(FactorEmision fe) {
	    return (transporte.huPorDistancia(distancia)/this.miembros.size());
	  }
}
