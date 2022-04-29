package dds.grupo3.clases;

import dds.grupo3.clases.organizacion.Organizacion;

import java.util.List;

public class Sector {
    public Organizacion organizacion;
    private String nombre;
    private List<Miembro> miembros;


    public Sector(String nombre) {
        super();
        this.nombre = nombre;
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }
}