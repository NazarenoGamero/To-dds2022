package dds.grupo3.clases.trayectos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Fisico extends Propio {

  public Fisico(String direccionInicio, String direccionLlegada) {
    super(direccionInicio, direccionLlegada);
  }
}