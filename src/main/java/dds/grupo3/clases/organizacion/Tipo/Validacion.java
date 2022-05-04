package dds.grupo3.clases.organizacion.Tipo;

import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import org.jetbrains.annotations.NotNull;

public interface Validacion {
    default boolean validar(Miembro miembro, Organizacion organizacion){
        if(organizacion.getPostulados().contains(miembro)){
            return true;
        }else{
            return false;
        }
    }
}

