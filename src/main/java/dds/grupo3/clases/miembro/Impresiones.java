package dds.grupo3.clases.miembro;

import java.util.ArrayList;
import java.util.Date;

public class Impresiones {
    private int cantidad;
    private long fechaDeImptuacion;
    private float valorDeconversion;

    public Impresiones(int cantidad, long fechaDeImptuacion, float valorDeconversion) {
        this.cantidad = cantidad;
        this.fechaDeImptuacion = fechaDeImptuacion;
        this.valorDeconversion = valorDeconversion;
    }
    public float miConsumo(){return cantidad*valorDeconversion;}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getFechaDeImptuacion() {
        return fechaDeImptuacion;
    }

    public void setFechaDeImptuacion(long fechaDeImptuacion) {
        this.fechaDeImptuacion = fechaDeImptuacion;
    }

    public float getValorDeconversion() {
        return valorDeconversion;
    }

    public void setValorDeconversion(float valorDeconversion) {
        this.valorDeconversion = valorDeconversion;
    }
}