package dds.grupo3.clases;

import java.io.IOException;
import java.util.List;

import dds.grupo3.clases.fachada.FachadaPosta;
import dds.grupo3.clases.medible.Medible;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class CalculadorHU {

	public static Float main(String[] args) throws IOException {

		ArgumentParser parser = ArgumentParsers.newFor("Checksum").build().defaultHelp(true)
				.description("Calculate checksum of given files.");
		parser.addArgument("-m", "--mediciones").required(true).help("Archivo de mediciones");
		parser.addArgument("-p", "--params").required(true).help("Archivo con parámetros de configuración");
		Namespace ns = null;
		try {
			ns = parser.parseArgs(args);
		} catch (ArgumentParserException e) {
			parser.handleError(e);
			System.exit(1);
		}

		System.out.println("Archivo de mediciones: " + ns.get("mediciones"));
		System.out.println("Archivo de parametros: " + ns.get("params"));

		// 1-Se inicaliza el sistema (Leer parametros, crear builder Org y objetos de clasificaciones y tipos)
		// 2-Se leen las mediciones
		// 3-Se calcula el HU (Puede llegar a imprimirse en pantalla un informe detallado)
		// 4-Se imprime en pantalla el total
		FachadaPosta fachada = new FachadaPosta();
		fachada.inicializar(ns.get("params"));
		List<Medible> mediciones = fachada.leerMediciones(ns.get("mediciones"));
		Float total = fachada.obtenerHU(mediciones);

		/*
		 * Mensaje seria un string largo del estilo
		 * ----Organizacion : Edesur
		 * -Mes de abril
		 * 10
		 * -Mes de Mayo
		 * 15
		 * 
		 */
		System.out.println("El total de la huella de carbono es: ");
		System.out.println(total);
		return total;

	}
}
