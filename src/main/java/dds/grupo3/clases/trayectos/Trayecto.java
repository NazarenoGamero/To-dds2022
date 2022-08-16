package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.miembro.Miembro;
import java.util.List;

public class Trayecto {
  private List<Tramo> tramos;

  public Trayecto(List<Tramo> tramos) {
    this.tramos = tramos;
  }

  public List<Tramo> getTramos() {
    return tramos;
  }

  public void setTramos(List<Tramo> tramos) {
    this.tramos = tramos;
  }

  public float distantiaTrayecto() {
    return (float) tramos.stream().mapToDouble(unTramo -> unTramo.distanciaTramo(unTramo.getTransporte())).sum();
  }

  public float calcularHU() {
    return (float) tramos.stream().mapToDouble(unTramo -> unTramo.calculaHU()).sum();
  }
}
