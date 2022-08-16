package dds.grupo3.clases.trayectos;

public class ServicioContratado extends Propio {
  private String nombre;

  public ServicioContratado(String direccionInicio, String direccionLlegada, String nombre) {
    super(direccionInicio, direccionLlegada);
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public float distancia(float latitud1, float longitud1, float latitud2, float longitud2) {
    return (float) 10;
  }
}