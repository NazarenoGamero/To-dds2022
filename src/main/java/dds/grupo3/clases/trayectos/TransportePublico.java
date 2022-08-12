package dds.grupo3.clases.trayectos;

public class TransportePublico implements Transporte {
  private String tipoVehiculo;
  private Parada paradaInicio;
  private Parada paradaLlegada;
  private Linea linea;

  public TransportePublico(String tipoVehiculo, Parada paradaInicio, Parada paradaLlegada,
                           Linea linea) {
    this.tipoVehiculo = tipoVehiculo;
    this.paradaInicio = paradaInicio;
    this.paradaLlegada = paradaLlegada;
    this.linea = linea;
  }

  //TODO preguntar por distancia del transporte publico
  public float distancia(float a, float b, float c, float d) {
    return 15;
  }

  public String getTipoVehiculo() {
    return tipoVehiculo;
  }

  public void setTipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
  }

  public Parada getParadaInicio() {
    return paradaInicio;
  }

  public void setParadaInicio(Parada paradaInicio) {
    this.paradaInicio = paradaInicio;
  }

  public Parada getParadaLlegada() {
    return paradaLlegada;
  }

  public void setParadaLlegada(Parada paradaLlegada) {
    this.paradaLlegada = paradaLlegada;
  }

  public Linea getLinea() {
    return linea;
  }

  public void setLinea(Linea linea) {
    this.linea = linea;
  }
}