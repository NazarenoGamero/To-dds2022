package dds.grupo3.clases.trayectos;

import java.util.Set;

public class Linea {
    private String nombre;
    private Set<Parada> paradas;

    public Linea(String nombre, Set<Parada> paradas) {
        this.nombre = nombre;
        this.paradas = paradas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(Set<Parada> paradas) {
        this.paradas = paradas;
    }
}