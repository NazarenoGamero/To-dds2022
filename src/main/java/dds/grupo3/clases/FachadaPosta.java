package dds.grupo3.clases;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FachadaPosta implements FachadaOrg {

	Map<String, Float> factoresDeEmision = new HashMap<>();

	@Override
	public void cargarParametros(Map<String, Float> parametrosSistema) {
		this.factoresDeEmision.putAll(parametrosSistema);
	}

	@Override
	public Float obtenerHU(Collection<Medible> mediciones) {
		return (float) mediciones.stream().mapToDouble(medicion -> obteneHuella(medicion)).sum();
	}

	private Float obteneHuella(Medible medible) {
		return obtenerFeAsociado(medible) * medible.getValor();
	}

	private Float obtenerFeAsociado(Medible medible) {
		return this.factoresDeEmision.get(medible.getTipoDeConsumo());

	}
	
	public Map<String, Float> getFactoresDeEmision() {
		return factoresDeEmision;
	}

}
