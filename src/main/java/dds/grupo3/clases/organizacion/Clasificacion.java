package dds.grupo3.clases.organizacion;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Clasificacion {
	@Column(name = "CLASIF")
  String nombre;

  public Clasificacion(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
