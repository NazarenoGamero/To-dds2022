package dds.grupo3.clases.organizacion.Tipo;

import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;

public class ValidacionONG_Gubernamental implements Validacion {
    @Override
    public boolean validar(Miembro miembro, Organizacion organizacion){
        boolean b = Validacion.super.validar(miembro, organizacion) && Validacion(miembro);
        return b;
    }
    public boolean Validacion(Miembro miembro){
        if(miembro.pertenescoEmpresa()){
            throw new RuntimeException("Pertenece a una empresa");
        }else{
            return true;
        }
    }
}
