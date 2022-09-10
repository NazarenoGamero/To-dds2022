package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sector {
  private Long id;
  public Organizacion organizacion;
  private String nombre;
  private List<Miembro> miembros;
  
  public String calcularHuellaMiembros() {
	  String mensajeSector = "Sector "+this.getNombre()+": \n";
	  for(Miembro unMiembro : this.getMiembros()) {
		  mensajeSector = mensajeSector + unMiembro.obtenerHU();
	  }
	  return mensajeSector;
  }
  
  public String huellaPorMiembro() {
	  float total=0;
	  for(Miembro unMiembro : this.getMiembros()) {
		  total = total + unMiembro.calcularHU();
	  }
	  String respuesta = "Huella del sector por miembro: "+(total/this.getMiembros().size());
	  return respuesta;
  }

  public void agregarMiembro(Miembro miembro) {
    miembros.add(miembro);
  }
}