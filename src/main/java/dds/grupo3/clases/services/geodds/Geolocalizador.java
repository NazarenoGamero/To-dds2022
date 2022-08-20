package dds.grupo3.clases.services.geodds;

import dds.grupo3.clases.services.geodds.Direccion;

public class Geolocalizador {
  public Direccion obtenerDireccion(Float latitud, Float longitud){
    return new Direccion("unaCalle", "99",1);
  }
}
