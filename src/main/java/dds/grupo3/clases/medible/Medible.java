package dds.grupo3.clases.medible;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MEDIBLE")
public class Medible {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private TipoDeMedicion tipoDeMedicion;
	
	@Column(name="VALOR")
	private float valor;
	
	@Column(name="PERIODICIDAD")
	private Periodicidad periodicidad;
	//Es un enum para saber durante cuanto tiempo se hizo esa medicion
	
	@Column(name="PERIODO")
	private String periodoDeImputacion;
	
	@ManyToOne
	private FactorEmision miFactor;
	
	@Column(name="FECHA")
	private Date fecha;
	
	@ManyToOne
	private BatchMediciones batch;

  //Periodicidad{
  // int 1 = Anual
  // int 0 = mensual

	public Medible(MedicionDTO dto){
		this.tipoDeMedicion= dto.getTipoDeMedicion();
		this.valor= dto.getValor();
		this.periodicidad= dto.getPeriodicidad();
		this.periodoDeImputacion=dto.getPeriodoDeImputacion();
		this.miFactor= dto.getMiFactor();
		this.fecha= dto.getFecha();
		this.batch= dto.getBatch();
	}

  public float obtenerHuella() {
    return this.valor * this.getMiFactor().getValor();
  }

  public void setFactorEmision(List<FactorEmision> factores) {
    for (FactorEmision unFactor : factores) {
      if (unFactor.getNombre() == this.tipoDeMedicion.getTipoDeactividad().getNombre()) {
        this.miFactor = unFactor;
      }
    }
  }
}