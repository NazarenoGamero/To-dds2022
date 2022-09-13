package dds.grupo3.clases.trayectos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportePublico implements Transporte {
  private TipoVehiculo tipoVehiculo;
  private Parada paradaInicio;
  private Parada paradaLlegada;
  private Linea linea;


  @Override
  public float distancia(float latitud1, float longitud1, float latitud2, float longitud2){
    return 30;
  }
}