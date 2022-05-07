package dds.grupo3.clases;

import java.io.IOException;

import dds.grupo3.clases.Fachada.FachadaOrg;
import dds.grupo3.clases.Fachada.FachadaPosta;
import dds.grupo3.clases.Readers.MedicionCSV;
import dds.grupo3.clases.Readers.ParametrosReader;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class CalculadorHU {

	public static void main(String[] args) throws IOException {

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

		FachadaOrg fachada = new FachadaPosta();
		ParametrosReader readerP = new ParametrosReader();
		MedicionCSV readerC = new MedicionCSV();

		fachada.cargarParametros(readerP.leerParametros(ns.get("params")));
		System.out.println("El total de la huella de carbono es: ");
		System.out.println(fachada.obtenerHU(readerC.leerArchivoMediciones(ns.get("mediciones"))));

	}
}
