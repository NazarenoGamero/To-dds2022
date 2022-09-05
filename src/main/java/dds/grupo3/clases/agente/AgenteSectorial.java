package dds.grupo3.clases.agente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgenteSectorial {
	private long id;
	private String nombre;
	private String email;
	private String telefono;
	private Territorio miTerritorio;

}
