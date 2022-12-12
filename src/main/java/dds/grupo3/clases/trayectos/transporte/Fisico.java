package dds.grupo3.clases.trayectos.transporte;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Fisico extends Transporte {

	@Override
	public float huPorDistancia(float distancia) {
		//Ya que no se emite HU al caminar/pedalear
		return 0;
	}
	
}