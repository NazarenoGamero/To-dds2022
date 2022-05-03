package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.Sector;

import java.util.List;

public class ClasificacionConSectores {
    private Clasificacion clasificacion;
    public List<Sector> sectoresObligatorios;

    public ClasificacionConSectores(Clasificacion unaClasificacion, List<Sector> unSector){
        this.clasificacion = unaClasificacion;
        this.sectoresObligatorios = unSector;
    }

    public void agregarSector(Sector sector) {
        sectoresObligatorios.add(sector);
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
}
