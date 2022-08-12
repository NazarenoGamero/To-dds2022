package dds.grupo3.clases.medible;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import java.util.List;

public class Medible {
  private TipoDeMedicion tipoDeMedicion;
  private float valor;
  private Periodicidad periodicidad;
  //Es un enum para saber durante cuanto tiempo se hizo esa medicion
  private String PeriodoDeImputacion;
  private FactorEmision miFactor;

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
  }

  public float obtenerHuella() {
    return this.valor * this.getMiFactor().getValor();
  }

  // Setters y Getters

  public TipoDeMedicion getTipoDeMedicion() {
    return tipoDeMedicion;
  }

  public void setTipoDeMedicion(TipoDeMedicion tipoDeMedicion) {
    this.tipoDeMedicion = tipoDeMedicion;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public Periodicidad getPeriodicidad() {
    return periodicidad;
  }

  public void setPeriodicidad(Periodicidad periodicidad) {
    this.periodicidad = periodicidad;
  }

  public void setFactorEmision(List<FactorEmision> factores) {
    for (FactorEmision unFactor : factores) {
      if (unFactor.getNombre() == this.tipoDeMedicion.getActividad().getNombre()) {
        ;
      }
      this.miFactor = unFactor;
    }
  }

  public float factorCorrespondienteAvalorMedible() {
    return miFactor.getValor();
  }

  public String getPeriodoDeImputacion() {
    return PeriodoDeImputacion;
  }

  public void setPeriodoDeImputacion(String periodoDeImputacion) {
    PeriodoDeImputacion = periodoDeImputacion;
  }

  public FactorEmision getMiFactor() {
    return miFactor;
  }

  public void setMiFactor(FactorEmision miFactor) {
    this.miFactor = miFactor;
  }
}