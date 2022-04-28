package dds.grupo3.clases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class MedicionCSV implements MedicionesReader{

    @Override
    public List<Medible> leerArchivoMediciones(String path) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] fila = null;
        Medible medicion = new Medible();

        try{
            while((fila = csvReader.readNext()) != null) {

            }
        } catch (FileNotFoundException e) {
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Mediciones;

        csvReader.close();
        }
}
