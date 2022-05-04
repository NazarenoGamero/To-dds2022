package dds.grupo3.clases.organizacion.Tipo;

import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;

public class ValidacionEmpresa implements Validacion{
    @Override
    public boolean validar(Miembro miembro, Organizacion organizacion){
        boolean b = Validacion.super.validar(miembro, organizacion) && Validacion(miembro);
        return b;
    }
    public boolean Validacion(Miembro miembro){
        if(miembro.pertenescoONGorGubernamental()){
            throw new RuntimeException("Pertenece a una ORG o Gubernamental");
        }if(miembro.cantidadEmpresasPertenesco()>=6){
            throw new RuntimeException("Pertenece a demasiadas empresas");
        }
        else{
            return true;
        }
    }
}
