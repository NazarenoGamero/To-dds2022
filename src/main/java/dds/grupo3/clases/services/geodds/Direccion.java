package dds.grupo3.clases.services.geodds;

public class Direccion {
  String calle;
  String altura;
  int localidadId;

  public Direccion(String calle, String altura, int localidadId) {
    this.calle = calle;
    this.altura = altura;
    this.localidadId = localidadId;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getAltura() {
    return altura;
  }

  public void setAltura(String altura) {
    this.altura = altura;
  }

  public int getLocalidadId() {
    return localidadId;
  }

  public void setLocalidadId(int localidadId) {
    this.localidadId = localidadId;
  }
}
