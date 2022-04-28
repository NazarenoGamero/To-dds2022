import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.FachadaPosta;

public class FachadaPostaTest {
	
	FachadaPosta fachada;
	
	@BeforeEach
	private void inicializarFachada()
	{
		fachada= new FachadaPosta();
	}

	@Test
	public void agregarParametros() 
	{
		Map<String,Float> parametros= new HashMap<>();
		parametros.put("ELECTRICIDAD", (float) 0.5);
		fachada.cargarParametros(parametros);
		
		Float valorFe = fachada.getFactoresDeEmision().get("ELECTRICIDAD");
		
		Assertions.assertEquals(valorFe, (float) 0.5);
	}
	
}
