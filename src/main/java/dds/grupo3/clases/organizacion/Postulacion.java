package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.miembro.Miembro;

public class Postulacion {
  private Sector sector;
  private Miembro miembro;

  public Postulacion(Miembro miembro, Sector sector) {
    this.miembro = miembro;
    this.sector = sector;
  }

  public Sector getSector() {
    return sector;
  }

  public Miembro getMiembro() {
    return miembro;
  }
}
