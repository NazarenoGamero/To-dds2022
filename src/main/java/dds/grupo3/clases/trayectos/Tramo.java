package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.miembro.Miembro;

import java.util.Set;

public class Tramo {
  private Transporte transporte;
  private Punto puntoInicio;
  private Punto puntoDeLlegada;
  private Set<Miembro> miembros;

  public Tramo(Transporte transporte, Punto puntoInicio, Punto puntoDeLlegada, Set<Miembro> miembros) {
    this.transporte = transporte;
    this.puntoInicio = puntoInicio;
    this.puntoDeLlegada = puntoDeLlegada;
    this.miembros = miembros;
  }

  public Transporte getTransporte() {
    return transporte;
  }

  public void setTransporte(Transporte transporte) {
    this.transporte = transporte;
  }

  public Punto getPuntoInicio() {
    return puntoInicio;
  }

  public void setPuntoInicio(Punto puntoInicio) {
    this.puntoInicio = puntoInicio;
  }

  public Punto getPuntoDeLlegada() {
    return puntoDeLlegada;
  }

  public void setPuntoDeLlegada(Punto puntoDeLlegada) {
    this.puntoDeLlegada = puntoDeLlegada;
  }

  public Set<Miembro> getMiembros() {
    return miembros;
  }

  public void setMiembros(Set<Miembro> miembros) {
    this.miembros = miembros;
  }

  public float distanciaTramo(Transporte transporte) {
    return transporte.distancia(puntoInicio.getLatitud(), puntoDeLlegada.getLongitud(), puntoDeLlegada.getLatitud(), puntoDeLlegada.getLongitud());
  }

  public float calculaHU() {
    return this.distanciaTramo(this.getTransporte()) * (float) 1.5;
  }
}
