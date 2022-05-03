package dds.grupo3.clases.Exception;

public class OrganizacionInvalida extends Throwable {
    public OrganizacionInvalida(){
        super("La organizacion no contiene todos los sectores obligatorios");
    }
}
