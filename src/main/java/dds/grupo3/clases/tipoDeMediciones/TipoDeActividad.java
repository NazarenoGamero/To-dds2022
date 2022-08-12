package dds.grupo3.clases.tipoDeMediciones;

public class TipoDeActividad {
  private String nombre;

  public TipoDeActividad(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}

/*
COMBUSTION_FIJA,
	COMBUSTION_MOVIL,
	ELECTRICIDAD_ADQUIRIDA_Y_CONSUMIDA,
	LOGISTICA_DE_PRODUCTOS_Y_RESIDUOS

*/