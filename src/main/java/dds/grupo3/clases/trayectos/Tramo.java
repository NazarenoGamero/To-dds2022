package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.trayectos.Punto;

public class Tramo {
    private Transporte unTransporte;
    private Punto unPuntoInicio;
    private Punto unPuntoDeLlegada;

    float distanciaTramo(Transporte unTransporte){
      return  unTransporte.distancia(unPuntoInicio.getLatitud(), unPuntoDeLlegada.getLongitud(), unPuntoDeLlegada.getLatitud(), unPuntoDeLlegada.getLongitud());
    }

    public Transporte getUnTransporte() {
        return unTransporte;
    }
}
