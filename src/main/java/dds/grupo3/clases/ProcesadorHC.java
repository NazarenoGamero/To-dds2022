package dds.grupo3.clases;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.util.List;

public class ProcesadorHC {
    private List<Organizacion> organizaciones;

    public void agregarOrganizacion(Organizacion organizacion) {
        organizaciones.add(organizacion);
    }

    public List<Organizacion> getOrganizaciones(){
        return this.organizaciones;
    }

    public Float calculoHCTotal(Medible medible, FachadaPosta fachadaPosta){
        return (float) organizaciones.stream().mapToDouble(organizacion->fachadaPosta.obteneHuellaPorMedicion(medible)).sum();
    }
}
