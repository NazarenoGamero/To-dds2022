package dds.grupo3.clases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MedicionCSV implements MedicionesReader {

	@Override
	public List<Medible> leerArchivoMediciones(String path) {
		String[] fila = null;
		List<Medible> mediciones = new ArrayList<>();

		try {
			CSVReader csvReader = new CSVReader(new FileReader(path));
			while ((fila = csvReader.readNext()) != null) {
				Medible medicion = new Medible(
						new TipoDeMedicion(fila[0], fila[1],
								null, null, null),
						Integer.valueOf(fila[2]), Periodicidad.valueOf(fila[3]), null);

				mediciones.add(medicion);
				csvReader.close();
			}

		} catch (

// TODO el que no commiteo, se encarga de esto.
				//1- Crear clases de excepciones.
				
		FileNotFoundException e) {
			throw new ArchivoNoEncontradoException();
		} catch (IOException e) {
			throw new ArchivoNoEncontradoException();
		} catch (CsvValidationException e) {
			throw new ArchivoNoEncontradoException();
		}

		return mediciones;

	}
}