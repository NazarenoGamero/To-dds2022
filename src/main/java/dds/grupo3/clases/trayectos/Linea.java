package dds.grupo3.clases.trayectos;

import java.util.Set;

public class Linea {
    private String nombreLinea;
    private Set<Parada> paradas;

    public Linea(String nombreLinea, Set<Parada> paradas) {
        this.nombreLinea = nombreLinea;
        this.paradas = paradas;
    }
}