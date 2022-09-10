package dds.grupo3.clases.agenteSectorial;

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
	private Organizacion miTerritorio;
	private String nombreTerritorio;
	
	
}
