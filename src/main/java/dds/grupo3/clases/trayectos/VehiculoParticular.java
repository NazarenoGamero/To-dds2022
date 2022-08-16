package dds.grupo3.clases.trayectos;

public class VehiculoParticular extends Propio {
  private String tipoCombustible;

  public VehiculoParticular(String direccionInicio, String direccionLlegada, String tipoCombustible) {
    super(direccionInicio, direccionLlegada);
    this.tipoCombustible = tipoCombustible;
  }

  public String getTipoCombustible() {
    return tipoCombustible;
  }

  public void setTipoCombustible(String tipoCombustible) {
    this.tipoCombustible = tipoCombustible;
  }

  @Override
  public float distancia(float latitud1, float longitud1, float latitud2, float longitud2) {
    return (float) 20;
  }
}