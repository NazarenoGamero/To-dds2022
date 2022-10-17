package dds.grupo3.api.dto.response;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicionTemplateDTO {
  private String tipoDeActividad;
  private String tipoDeConsumo;
  private float valor;
}
