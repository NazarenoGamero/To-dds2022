package dds.grupo3.clases.fachada;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.medible.Periodicidad;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.readers.MedicionCSV;
import dds.grupo3.clases.readers.ParametrosReader;
import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

public class FachadaPosta implements FachadaOrg {

	List<FactorEmision> factoresDeEmision = new ArrayList<FactorEmision>();

	@Override
	public void cargarParametros(Map<String, Float> parametrosSistema) {
		//Creo objetos y los guardo en factoresDeEmision
		parametrosSistema.forEach((k,v) -> factoresDeEmision.add(new FactorEmision(k,v)));
	}

	@Override
	public Float obtenerHU(Collection<Medible> mediciones) {
		//TODO aca se suman todos los valores de las mediciones
	}
	/*
	public Float obteneHuellaPorMedicion(Medible medible) {
		return obtenerFeAsociado(medible) * medible.getValor();
	}

	private Float obtenerFeAsociado(Medible medible) {
		return this.factoresDeEmision.get(medible.getTipoDeMedicion().getTipoDeConsumo().getNombre());

	}

	public Map<String, Float> getFactoresDeEmision() {
		return factoresDeEmision;
	}
	*/
	
	public void crearMedibles(String pathCsv) {
		MedicionCSV readerC = new MedicionCSV();
		List<Medible> medibles = readerC.leerArchivoMediciones(pathCsv);
		for (Medible elemento : medibles) {
			elemento.setFactorEmision(factoresDeEmision);
		}
	}
	
	public void inicializar(String pathParametros, String pathCsv) {
		ParametrosReader readerP = new ParametrosReader();
		//asignar factores de emision
		
		Map<String, Float> parametros = readerP.leerParametros(pathParametros); //TODO:Atender esta excepcion
		
		crearMedibles(pathCsv);
		
		cargarParametros(parametros);
	}
	
	public Float pedirCalculoHC(Organizacion unaOrg) {
		return obtenerHU(unaOrg.getMediciones());
	}
}