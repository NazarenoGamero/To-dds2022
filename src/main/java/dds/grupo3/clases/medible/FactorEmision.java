package dds.grupo3.clases.medible;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactorEmision {
  private String nombre;
  private float valor;
  private Long id;

  public FactorEmision(String nombre, float valor){
    this.nombre = nombre;
    this.valor = valor;
  }
}