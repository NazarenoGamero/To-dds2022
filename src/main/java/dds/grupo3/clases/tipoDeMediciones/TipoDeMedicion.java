package dds.grupo3.clases.tipoDeMediciones;

import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeMedicion {
  private TipoDeActividad tipoDeactividad;
  private TipoDeConsumo tipoDeConsumo;
  private Unidad unidad;
  private Alcance alcance;

  //TODO Ver forma para que resuelva y sepa asociar que cuando es combustion fija por ejemplo de gas natural, la unidad sea m3 y el alcance de 1: Emisiones directas
}