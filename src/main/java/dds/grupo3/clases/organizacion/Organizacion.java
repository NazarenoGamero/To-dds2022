package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.Medible;
import dds.grupo3.clases.Sector;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private Tipo tipo;
    private List<Sector> unSector = new ArrayList<Sector>();
    private Clasificacion unaClasificaion;
    private List<Medible> unaMedicion = new ArrayList<Medible>();


    public Organizacion(String razonSocial, Tipo tipo , List<Sector> unSector, Clasificacion unaClasificaion) {
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        //this.unSector = unSector;
        this.unaClasificaion = unaClasificaion;
    }

    public void setUnaMedicion(List<Medible> unaMedicion) {
        this.unaMedicion = unaMedicion;
    }
    /* agregar estas funciones mas tarde */
    public void aceptarVinculacionConMiembro(){
        return;
    }
    public float calcularHuellaDeCarbonoST(){
        return 0;
    }

    /*
    public void getMiembros(){
        return unSector.getMiembros()
    }
     */

}
