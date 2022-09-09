package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.miembro.Miembro;
import java.util.ArrayList;
import java.util.List;

public class Sector {
  public Organizacion organizacion;
  private String nombre;
  private List<Miembro> miembros;
  
  public String calcularHuellaMiembros() {
	  String mensajeSector = "Sector "+this.getNombre()+": \n";
	  for(Miembro unMiembro : this.getMiembros()) {
		  mensajeSector = mensajeSector + unMiembro.obtenerHU();
	  }
	  return mensajeSector;
  }
  
  public String huellaPorMiembro() {
	  float total=0;
	  for(Miembro unMiembro : this.getMiembros()) {
		  total = total + unMiembro.calcularHU();
	  }
	  String respuesta = "Huella del sector por miembro: "+(total/this.getMiembros().size());
	  return respuesta;
  }

  public Organizacion getOrganizacion() {
    return organizacion;
  }

  public void setOrganizacion(Organizacion organizacion) {
    this.organizacion = organizacion;
  }

  public Sector(String nombre) {
    this.nombre = nombre;
    this.organizacion = null;
    this.miembros = new ArrayList<Miembro>();
  }

  public void agregarMiembro(Miembro miembro) {
    miembros.add(miembro);
  }

  public String getNombre() {
    return nombre;
  }

  public List<Miembro> getMiembros() {
    return miembros;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setMiembros(List<Miembro> miembros) {
    this.miembros = miembros;
  }
}