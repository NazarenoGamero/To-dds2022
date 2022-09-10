package dds.grupo3.clases.medible;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medible {
  private long id;
  private TipoDeMedicion tipoDeMedicion;
  private float valor;
  private Periodicidad periodicidad;
  //Es un enum para saber durante cuanto tiempo se hizo esa medicion
  private String PeriodoDeImputacion;
  private FactorEmision miFactor;
  private Date fecha;

  //Periodicidad{
  // int 1 = Anual
  // int 0 = mensual


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