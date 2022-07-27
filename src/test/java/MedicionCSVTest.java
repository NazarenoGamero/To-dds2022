import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.readers.MedicionCSV;


public class MedicionCSVTest {
	MedicionCSV reader = new MedicionCSV();

	@Test
	public void puedeLeerArchivoDeParametros() throws IOException {
		String path = System.getProperty("user.dir") + "/src/files/" + "/mediciones.csv";
		List<Medible> mediciones = new ArrayList<>();
		mediciones = reader.leerArchivoMediciones(path);

		Assertions.assertEquals(50, mediciones.get(0).getValor());
	}

}
