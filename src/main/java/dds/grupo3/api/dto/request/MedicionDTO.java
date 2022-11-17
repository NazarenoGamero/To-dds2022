package dds.grupo3.api.dto.request;

import java.util.Date;

import dds.grupo3.clases.medible.Medible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicionDTO {

  private TipoDeMedicionDTO tipoDeMedicion;

  private float valor;

  private String periodicidad;

  private String periodoDeImputacion;

  private Date fecha;

  public MedicionDTO(Medible medible){
    this.fecha= medible.getFecha();
    this.periodicidad= medible.getPeriodicidad().toString();
    this.periodoDeImputacion= medible.getPeriodoDeImputacion();
    this.tipoDeMedicion= new TipoDeMedicionDTO(medible.getTipoDeMedicion());
    this.valor= medible.getValor();
  }
}
