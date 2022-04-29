import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.Medible;
import dds.grupo3.clases.MedicionCSV;
import dds.grupo3.clases.ParametrosReader;

public class MedicionCSVTest {
	MedicionCSV reader = new MedicionCSV();

	@Test
	public void puedeLeerArchivoDeParametros() throws IOException {
		String path = System.getProperty("user.dir") + "/src/files/" + "/Medicion.CSV";
		List<Medible> mediciones = new ArrayList<>();
		mediciones = reader.leerArchivoMediciones(path);

		Assertions.assertEquals(50, mediciones.get(0).getValor());
	}

}
