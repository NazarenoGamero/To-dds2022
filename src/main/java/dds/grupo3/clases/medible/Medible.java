package dds.grupo3.clases.medible;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Medible {
  private TipoDeMedicion tipoDeMedicion;
  private float valor;
  private Periodicidad periodicidad;
  //Es un enum para saber durante cuanto tiempo se hizo esa medicion
  private String PeriodoDeImputacion;
  private FactorEmision miFactor;
  private Date fecha;

  //Periodicidad{
  // 	int 1 = Anual
  // int 0 = mensual

  // Constructor

  public Medible(TipoDeMedicion tipoDeMedicion, int valor, Periodicidad periodicidad,
                 String periodoDeImputacion, FactorEmision miFactor) {
    this.tipoDeMedicion = tipoDeMedicion;
    this.valor = valor;
    this.periodicidad = periodicidad;
    this.PeriodoDeImputacion = periodoDeImputacion;
    this.miFactor = miFactor;
    this.fecha = new Date();
  }

  public float obtenerHuella() {
    return this.valor * this.getMiFactor().getValor();
  }

  public void setFactor(FactorEmision factorEmision) {
	  this.miFactor= factorEmision;
  }
  
  public void setFactorEmision(List<FactorEmision> factores) {
    for (FactorEmision unFactor : factores) {
      if (unFactor.getNombre() == this.tipoDeMedicion.getActividad().getNombre()) {
        this.miFactor = unFactor;
      }
    }
  }

  public float factorCorrespondienteAvalorMedible() {
    return miFactor.getValor();
  }
}