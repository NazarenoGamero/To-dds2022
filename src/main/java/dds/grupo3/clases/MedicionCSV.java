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
	public List<Medible> leerArchivoMediciones(String path) throws IOException, IOException {
		CSVReader csvReader = new CSVReader(new FileReader(path));
		String[] fila = null;
		List<Medible> mediciones = new ArrayList<>();

		try {
			while ((fila = csvReader.readNext()) != null) {
				Medible medicion = new Medible(
						new TipoDeMedicion(TipoDeActividad.valueOf(fila[0]), TipoDeConsumo.valueOf(fila[1])),
						Integer.valueOf(fila[2]), Periodicidad.valueOf(fila[3]), null);
				
				mediciones.add(medicion);
			}
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}

		csvReader.close();
		return mediciones;
		
	}
}
/*
	TipoDeMedicion tipodeMedicion = new TipoDeMedicion(null, null);
Medible medicion = new Medible(parts[2].parseInt(), );
}else{System.out.println("ignoring line: "+fila);}
*/
	
/*
 * Combustion fija,Gas Natural,50,Mensual,05/2021 Combustion fija,Gas
 * Natural,50,Mensual,05/2021 0 TipoDeMedicion: Actividad = 0 Tipo de consumo =
 * 1 Unidad = Alcance =
 */
/*
 * TipoDeMedicion Actividad TipoDeConsumo Unidad Alcance
 * 
 * Medicion TipoDeMedicion(Comsution) Valor Periodicidad Periodo
 */