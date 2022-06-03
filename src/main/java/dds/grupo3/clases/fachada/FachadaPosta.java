package dds.grupo3.clases.fachada;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.BuilderOrg;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.readers.MedicionCSV;
import dds.grupo3.clases.readers.ParametrosReader;

public class FachadaPosta implements FachadaOrg {
	//Estas listas pueden moverse a otras clases, luego cuando se vean patrones creacionales... creo
	List<FactorEmision> factoresDeEmision;
	BuilderOrg creadorOrg;
	
	@Override
	public void cargarParametros(Map<String, Float> parametrosSistema) {
		//Creo objetos y los guardo en factoresDeEmision
		parametrosSistema.forEach((k,v) -> factoresDeEmision.add(new FactorEmision(k,v)));
	}

	/*
	 * Se elije crear aca la organizacion para facilitar el proceso de medicion
	 * 1)Se puede establecer otro "obtenerHU" con un parametro mas para una organizacion en especifico
	 * 		-Method Overloading para mas info
	 * 2)Esto es una solucion provisoria ya que no se recibe informacion de la organizacion a medir
	 */
	@Override
	public Float obtenerHU(Collection<Medible> mediciones) {
		Organizacion nuevaOrg = creadorOrg.crearOrg();
		nuevaOrg.setMediciones((List<Medible>) mediciones);
		Float datos = nuevaOrg.calcularHuellaDeCarbonoST();
		return datos; 
	}
	//La idea seria que de una lista de floats, arme un informe de los meses de emision
	// Map<Int, Int> // Map<Anio, TotalAnio> o Map<Mes, TotalMes>
	
	public List<Medible> leerMediciones(String pathCsv) {
		MedicionCSV readerC = new MedicionCSV();
		List<Medible> medibles = readerC.leerArchivoMediciones(pathCsv,this.getFactoresDeEmision());
		return medibles;
		//TODO: Agregar como conectar los medibles con sus factores de emision
	}
	
	
	/* 
	 * Se cargan los factores de medicion en el sistema. Pueden agregarse mas cosas para la hora de iniciar el 
	 * sistema 
	 */
	public void inicializar(String pathParametros) {
		ParametrosReader readerP = new ParametrosReader();
		
		try {
			Map<String, Float> parametros = readerP.leerParametros(pathParametros);
			cargarParametros(parametros);
		}catch(IOException ioe){
			System.out.printf("Error, los parametros ingresados no son validos");
		}
		 //TODO:Atender esta excepcion
		creadorOrg.Inicializar();
	}
	
	
	/*
	 * Constructor
	 */
	public FachadaPosta(){
		this.factoresDeEmision = new ArrayList<FactorEmision>();
		this.creadorOrg = new BuilderOrg();
	}

	public List<FactorEmision> getFactoresDeEmision() {
		return factoresDeEmision;
	}

	public void setFactoresDeEmision(List<FactorEmision> factoresDeEmision) {
		this.factoresDeEmision = factoresDeEmision;
	}

	public BuilderOrg getCreadorOrg() {
		return creadorOrg;
	}

	public void setCreadorOrg(BuilderOrg creadorOrg) {
		this.creadorOrg = creadorOrg;
	}
}