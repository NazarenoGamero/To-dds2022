package dds.grupo3.clases.organizacion.Tipo;

import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;

public class TipoOrg {
    private Tipo tipo;
    private Validacion validacion;


    public boolean validar(Miembro miembro, Organizacion organizacion){
        return validacion.validar(miembro, organizacion);
    }
}
