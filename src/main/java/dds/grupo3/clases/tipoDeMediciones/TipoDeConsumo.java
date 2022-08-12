package dds.grupo3.clases.tipoDeMediciones;

public class TipoDeConsumo {
  private String nombre;
  private int valor;

  public TipoDeConsumo(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

}

/*
 * GAS_NATURAL, DIESEL_GASOIL, KEROSENE, FUEL_OIL, NAFTA, CARBON, CARBON_DE_LENIA, LENIA, ELECTRICIDAD
 *
 */

