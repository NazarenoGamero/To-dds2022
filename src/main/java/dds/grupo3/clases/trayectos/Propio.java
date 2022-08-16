package dds.grupo3.clases.trayectos;

public abstract class Propio implements Transporte {
    private String direccionInicio;
    private String direccionLlegada;

    public Propio(String direccionInicio, String direccionLlegada) {
        this.direccionInicio = direccionInicio;
        this.direccionLlegada = direccionLlegada;
    }

    public String getDireccionInicio() {
        return direccionInicio;
    }

    public void setDireccionInicio(String direccionInicio) {
        this.direccionInicio = direccionInicio;
    }

    public String getDireccionLlegada() {
        return direccionLlegada;
    }

    public void setDireccionLlegada(String direccionLlegada) {
        this.direccionLlegada = direccionLlegada;
    }

    @Override
    public float distancia(float latitud1, float longitud1, float latitud2, float longitud2){
        return 0;
    }
}
