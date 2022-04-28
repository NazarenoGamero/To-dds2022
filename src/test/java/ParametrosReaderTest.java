import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.ParametrosReader;

public class ParametrosReaderTest {
	ParametrosReader reader;
	
	@Test
	public void puedeLeerArchivoDeParametros()
	{
		String path= System.getProperty("user.dir") + "/src/files/"+"/parametros.txt";
		reader= new ParametrosReader();
		Map<String,Float> parametros= new HashMap<>();
		parametros= reader.leerParametros(path);
		
		Assertions.assertEquals((float)0.5, parametros.get("ELECTRICIDAD"));
	}
	
	
}
