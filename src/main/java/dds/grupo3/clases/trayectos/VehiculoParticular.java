package dds.grupo3.clases.trayectos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoParticular extends Propio {
  private String tipoCombustible;


  @Override
  public float distancia(float latitud1, float longitud1, float latitud2, float longitud2) {
    return (float) 20;
  }
}