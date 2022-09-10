package dds.grupo3.clases.agenteSectorial;

import java.util.List;

import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgenteSectorial {
	private String nombre;
	private List<Organizacion> miTerritorio;
	private String nombreTerritorio;
	private String email;
	
	public float calcularHuellaTerritorio() {
		float total=0;
		for(Organizacion unaOrg : miTerritorio) {
			total=total+1;//TODO cambiar a algo con sentido
		}
		return total;
	}
}