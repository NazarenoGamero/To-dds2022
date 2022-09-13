package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tramo {
  private Transporte transporte;
  private Punto puntoInicio;
  private Punto puntoDeLlegada;
  private Set<Miembro> miembros;


  public float distanciaTramo(Transporte transporte) {
    return transporte.distancia(puntoInicio.getLatitud(), puntoDeLlegada.getLongitud(), puntoDeLlegada.getLatitud(), puntoDeLlegada.getLongitud());
  }

  public float calculaHU() {
    return this.distanciaTramo(this.getTransporte()) * (float) 1.5;
  }
}
