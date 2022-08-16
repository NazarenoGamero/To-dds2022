package dds.grupo3.clases.trayectos;

public class TransportePublico implements Transporte {
  private TipoVehiculo tipoVehiculo;
  private Parada paradaInicio;
  private Parada paradaLlegada;
  private Linea linea;

  public TransportePublico(TipoVehiculo tipoVehiculo, Parada paradaInicio, Parada paradaLlegada, Linea linea) {
    this.tipoVehiculo = tipoVehiculo;
    this.paradaInicio = paradaInicio;
    this.paradaLlegada = paradaLlegada;
    this.linea = linea;
  }

  public TipoVehiculo getTipoVehiculo() {
    return tipoVehiculo;
  }

  public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
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

  @Override
  public float distancia(float latitud1, float longitud1, float latitud2, float longitud2){
    return 30;
  }
}