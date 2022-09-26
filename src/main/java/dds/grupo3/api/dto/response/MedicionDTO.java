package dds.grupo3.api.dto.response;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.medible.Periodicidad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicionDTO {
  private long id;

  private TipoDeMedicion tipoDeMedicion;

  private float valor;

  private Periodicidad periodicidad;

  private String PeriodoDeImputacion;

  private FactorEmision miFactor;

  private Date fecha;

  public MedicionDTO(Medible medible){
    this.fecha=medible.getFecha();
    this.id= medible.getId();
    this.miFactor= medible.getMiFactor();
    this.tipoDeMedicion= medible.getTipoDeMedicion();
    this.periodicidad= medible.getPeriodicidad();
    this.PeriodoDeImputacion= medible.getPeriodoDeImputacion();
    this.valor= medible.getValor();
  }

}
