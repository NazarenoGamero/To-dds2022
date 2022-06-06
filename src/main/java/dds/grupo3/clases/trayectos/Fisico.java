package dds.grupo3.clases.trayectos;

public class Fisico implements Transporte{
    private String tipoVehiculo;
    private String direccionInicio;
    private String direccionLlegada;

    public Fisico(String tipoVehiculo, String direccionInicio, String direccionLlegada) {
        this.tipoVehiculo = tipoVehiculo;
        this.direccionInicio = direccionInicio;
        this.direccionLlegada  = direccionLlegada;
    }

    public float distancia(float latitud1, float longitud1, float latitud2, float longitud2){
        return (float) 1;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
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
}
