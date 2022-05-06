package dds.grupo3.clases.Exception;

public class MiembroNoVinculadoException extends RuntimeException {
    public MiembroNoVinculadoException(){
        super("El miembro no esta vinculado.");
    }
}