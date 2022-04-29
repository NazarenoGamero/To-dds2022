package dds.grupo3.clases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MedicionCSV implements MedicionesReader{

    @Override
    public List<Medible> leerArchivoMediciones(String path) throws IOException, IOException {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] fila = null;

        try{
            while((fila = csvReader.readNext()) != null) {
                String[] parts = fila.split(",",5);
                if (parts.length == 5)
                {
                    TipoDeMedicion tipodeMedicion = new TipoDeMedicion(parts[0].toUpperCase().replace(" ","_"),
                            parts[1].toUpperCase().replace(" ","_"));
                    Medible medicion = new Medible(parts[2].parseInt(), );
                } else {
                    System.out.println("ignoring line: " + fila);
                }
                /*
                Combustion fija,Gas Natural,50,Mensual,05/2021
                Combustion fija,Gas Natural,50,Mensual,05/2021
                        0
                TipoDeMedicion:
                Actividad = 0
                Tipo de consumo = 1
                Unidad =
                Alcance =
                 */
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

        return Mediciones;

        csvReader.close();
    }
}


/*
TipoDeMedicion
Actividad
TipoDeConsumo
Unidad
Alcance

Medicion
TipoDeMedicion(Comsution)
Valor
Periodicidad
Periodo
 */