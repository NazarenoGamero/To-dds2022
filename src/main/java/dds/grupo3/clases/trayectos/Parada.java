package dds.grupo3.clases.trayectos;

public class Parada {
    private String nombreParada;
    private Punto puntoParada;
    private Parada proximaParada;
    private Parada anteriorParada;


    public Parada(String nombreParada, Punto puntoParada, Parada proximaParada, Parada anteriorParada) {
        this.nombreParada = nombreParada;
        this.puntoParada = puntoParada;
        this.proximaParada = proximaParada;
        this.anteriorParada = anteriorParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public Punto getPuntoParada() {
        return puntoParada;
    }

    public Parada getProximaParada() {
        return proximaParada;
    }

    public Parada getAnteriorParada() {
        return anteriorParada;
    }
    public float latitudPunto(){
        return puntoParada.getLatitud();
    }
    public float longitudPunto(){
        return puntoParada.getLongitud();
    }
}