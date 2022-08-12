package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.miembro.Miembro;
import java.util.List;

public class Trayecto {
  private List<Tramo> unosTramos;
  private List<Miembro> unosMiembros;


  public Trayecto(List<Tramo> unosTramos, List<Miembro> unosMiembros) {
    this.unosTramos = unosTramos;
    this.unosMiembros = unosMiembros;
  }

  public void setUnosMiembros(List<Miembro> unosMiembros) {
    this.unosMiembros = unosMiembros;
  }

  public float distantiaTotal() {
    return (float) unosTramos.stream()
        .mapToDouble(unTramo -> unTramo.distanciaTramo(unTramo.getUnTransporte())).sum();
  }

  public float calcularHU() {
    return 0;
  }
}
