package dds.grupo3.clases.trayectos;

public class Tramo implements Recorrido{
    private Transporte unTransporte;
    private Punto unPuntoInicio;
    private Punto unPuntoDeLlegada;
/*
    public float distanciaTramo(Transporte unTransporte){
      return  unTransporte.distancia(unPuntoInicio.getLatitud(), unPuntoDeLlegada.getLongitud(), unPuntoDeLlegada.getLatitud(), unPuntoDeLlegada.getLongitud());
    }
*/
    public Transporte getUnTransporte() {
        return unTransporte;
    }

    @Override
    public float distancia() {
        return  unTransporte.distancia(unPuntoInicio.getLatitud(), unPuntoDeLlegada.getLongitud(), unPuntoDeLlegada.getLatitud(), unPuntoDeLlegada.getLongitud());
    }
}
