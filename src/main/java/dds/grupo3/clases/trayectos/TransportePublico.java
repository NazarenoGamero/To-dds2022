package dds.grupo3.clases.trayectos;

public class TransportePublico {
    private String tipoVehiculo;
    private Parada paradaInicio;
    private Parada paradaLlegada;
    private Linea linea;

    public TransportePublico(String tipoVehiculo, Parada paradaInicio, Parada paradaLlegada, Linea linea) {
        this.tipoVehiculo = tipoVehiculo;
        this.paradaInicio = paradaInicio;
        this.paradaLlegada = paradaLlegada;
        this.linea = linea;
    }
/*
    public float distancia(paradaInicio.puntoParada.latitud, paradaInicio.puntoParada.longutid, paradaLlegada.puntoParada.latitud, paradaLlegada.puntoParada.latitud){
        return 15;
    }
*/
}