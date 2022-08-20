package dds.grupo3.clases.services.geodds;

import dds.grupo3.clases.services.CalculadorDeDistancias;

public class ServicioGeoddsAdapter implements CalculadorDeDistancias {
  private ServicioGeodds servicioGeodds;
  Geolocalizador geolocalizador;

  public ServicioGeoddsAdapter(){
    servicioGeodds= ServicioGeodds.instancia();
    geolocalizador = new Geolocalizador();
  }
  public Float distancia(Float latitud1, Float longitud1, Float latitud2, Float longitud2) {
    Direccion dir1= geolocalizador.obtenerDireccion(latitud1,longitud1);
    Direccion dir2= geolocalizador.obtenerDireccion(latitud2,longitud2);
    return servicioGeodds.distancia(dir1.getLocalidadId(),dir1.getCalle(),dir1.getAltura()
        ,dir2.getLocalidadId(),dir2.getCalle(),dir2.getAltura()).getValor();
  }
}

