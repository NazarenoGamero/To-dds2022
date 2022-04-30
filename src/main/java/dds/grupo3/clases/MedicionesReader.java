package dds.grupo3.clases;

import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface MedicionesReader {
	public List<Medible> leerArchivoMediciones(String path);
}