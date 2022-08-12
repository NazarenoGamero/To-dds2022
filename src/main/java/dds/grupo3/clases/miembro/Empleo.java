package dds.grupo3.clases.miembro;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;

public class Empleo {
  private Organizacion organizacion;
  private Sector sector;

  public Empleo(Organizacion organizacion, Sector sector) {
    this.organizacion = organizacion;
    this.sector = sector;
  }
}
