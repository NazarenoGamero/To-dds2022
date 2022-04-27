package dds.grupo3.clases;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FachadaPosta implements FachadaOrg {

	List<FactorDeEmision> factoresDeEmision;

	@Override
	public void cargarParametros(Map<String, Float> parametrosSistema) {

	}

	@Override
	public Float obtenerHU(Collection<Medible> mediciones) {
		return (float) mediciones.stream().mapToDouble(medicion -> obteneHuella(medicion)).sum();
	}

	private Float obteneHuella(Medible medible) {
		return obtenerFeAsociado(medible).getValor() * medible.getDA();
	}

	private FactorDeEmision obtenerFeAsociado(Medible medible) {
		// TODO: cambiar tipoDeConsumo de Medible de String a Enum
		return this.factoresDeEmision.stream().filter(fe -> fe.getTipoCons().equals(medible.getTipoDeConsumo()))
				.findFirst().orElse(null);
	}

}
