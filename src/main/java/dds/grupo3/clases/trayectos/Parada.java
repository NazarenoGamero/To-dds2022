package dds.grupo3.clases.trayectos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parada extends Punto{
  private String nombreParada;
  private Punto paradaAnterior;
  private Punto paradaProxima;
}