package dds.grupo3.clases.tipoDeMediciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeConsumo {
  private String nombre;
  private int valor;
}

/*
 * GAS_NATURAL, DIESEL_GASOIL, KEROSENE, FUEL_OIL, NAFTA, CARBON, CARBON_DE_LENIA, LENIA, ELECTRICIDAD
 *
 */