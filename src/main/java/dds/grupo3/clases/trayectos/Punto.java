package dds.grupo3.clases.trayectos;

public class Punto {
    private float latitud;
    private float longitud;

    public Punto(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }
}
