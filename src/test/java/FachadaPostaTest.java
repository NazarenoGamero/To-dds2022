import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.Fachada.FachadaPosta;
import dds.grupo3.clases.Medible.Medible;
import dds.grupo3.clases.Readers.ParametrosReader;
import dds.grupo3.clases.Medible.Periodicidad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

public class FachadaPostaTest {

	FachadaPosta fachada;
	ParametrosReader reader = new ParametrosReader();
	String path = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";

	@BeforeEach
	private void inicializarFachada() throws IOException {
		fachada = new FachadaPosta();
	}

	@Test
	public void puedeAgregarParametros() {
		Map<String, Float> parametros = new HashMap<>();
		parametros.put("ELECTRICIDAD", (float) 0.5);
		fachada.cargarParametros(parametros);

		Float valorFe = fachada.getFactoresDeEmision().get("ELECTRICIDAD");

		Assertions.assertEquals(valorFe, (float) 0.5);
	}

	@Test
	public void calculoDeHuellaTotal() throws IOException {
		fachada.cargarParametros(reader.leerParametros(path));
		Assertions.assertEquals(870, fachada.obtenerHU(cargarMedibles()));
	}

	public List<Medible> cargarMedibles() {
		List<Medible> medibles = new ArrayList<>();

		// FeCarbon= 0.45 consumo=600
		Medible m1 = new Medible(new TipoDeMedicion(new TipoDeActividad("COMBUSTION_FIJA"),
				new TipoDeConsumo("CARBON")), 600,
				new Periodicidad("ANUAL"), null);

		// FeElectricidad= 0.5 consumo=500
		Medible m2 = new Medible(
				new TipoDeMedicion(new TipoDeActividad("ELECTRICIDAD_ADQUIRIDA_Y_CONSUMIDA"),
						new TipoDeConsumo("ELECTRICIDAD")), 500,
				new Periodicidad("ANUAL"), null);

		// FeElectricidad= 0.5 consumo=700
		Medible m3 = new Medible(new TipoDeMedicion(new TipoDeActividad("COMBUSTION_FIJA"), 
				new TipoDeConsumo("ELECTRICIDAD")), 700,
				new Periodicidad("ANUAL"), null);

		medibles.add(m1);
		medibles.add(m2);
		medibles.add(m3);

		return medibles;
	}
}
