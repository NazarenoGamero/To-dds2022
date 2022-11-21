package dds.grupo3.clases.trayectos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trayecto {
  private List<Tramo> tramos;


  public float distantiaTrayecto() {
    return (float) tramos.stream().mapToDouble(unTramo -> unTramo.distanciaTramo(unTramo.getTransporte())).sum();
  }

  public float calcularHU() {
    return (float) tramos.stream().mapToDouble(unTramo -> unTramo.calculaHU()).sum();
  }
}
