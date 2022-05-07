package dds.grupo3.clases.readers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dds.grupo3.clases.exception.ArchivoNoEncontradoException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.medible.Periodicidad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicionCSV implements MedicionesReader {

	@Override
	public List<Medible> leerArchivoMediciones(String path) {
		String[] fila = null;
		List<Medible> mediciones = new ArrayList<>();

		try {
			CSVReader csvReader = new CSVReader(new FileReader(path));
			while ((fila = csvReader.readNext()) != null) {
				Medible medicion = new Medible(
						new TipoDeMedicion(new TipoDeActividad((fila[0])), new TipoDeConsumo(fila[1])),
						Integer.valueOf(fila[2]),new Periodicidad(fila[3]), null);

				mediciones.add(medicion);
				csvReader.close();
			}

		} catch (FileNotFoundException e) {
			throw new ArchivoNoEncontradoException();
		} catch (IOException e) {
			throw new ArchivoNoEncontradoException();
		} catch (CsvValidationException e) {
			throw new ArchivoNoEncontradoException();
		}

		return mediciones;

	}
}