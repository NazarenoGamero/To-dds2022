import dds.grupo3.clases.*;
import dds.grupo3.clases.Exception.MiembroNoPostuladoException;
import dds.grupo3.clases.Exception.YaPerteneceOrgException;

import static dds.grupo3.clases.TipoDocEnum.DNI;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dds.grupo3.clases.organizacion.Clasificacion.UNIVERSIDAD;
import static dds.grupo3.clases.organizacion.Tipo.INSTITUCION;

public class OrganizacionTest {
	Organizacion organizacion1;
	Organizacion organizacion2;
	Sector sector1;
	Sector sector2;
	Miembro miembro;
	ProcesadorHC procesadorHC;
	Medible medible;
	FachadaPosta fachadaPosta;
	List<Sector> sectores = new ArrayList<>();

	FachadaPosta fachada;
	MedicionCSV reader = new MedicionCSV();
	String path = System.getProperty("user.dir") + "/src/files/" + "/mediciones.CSV";

	@BeforeEach
	private void inicializarOrganizacion() throws IOException {
		organizacion1 = new Organizacion("LaUni", INSTITUCION, sectores, UNIVERSIDAD);
		organizacion2 = new Organizacion("LaUni", INSTITUCION, sectores, UNIVERSIDAD);
		sector1 = new Sector("sector1");
		sector2 = new Sector("sector2");
		miembro = new Miembro("Juan", "Pirulito", DNI, 43858878);
		medible = new Medible(new TipoDeMedicion(TipoDeActividad.REACCION_NUCLEAR, TipoDeConsumo.REACTIVO_MEDICINA), 5, );
		fachadaPosta = new FachadaPosta();
		procesadorHC.agregarOrganizacion(organizacion1);
		procesadorHC.agregarOrganizacion(organizacion2);
	}

	@Test
	public void unSectorNoPuedePertenecerAdosOrg() throws YaPerteneceOrgException {
		organizacion1.agregarSector(sector1);
	    Assertions.assertThrows(YaPerteneceOrgException.class, ()->{organizacion2.agregarSector(sector1);});
	}

	@Test
	public void calculoHuellaTotal() throws IOException {
		Assertions.assertEquals(35, organizacion1.calcularHuellaDeCarbonoST(reader.leerArchivoMediciones(path)));
	}

	@Test
	public void calculoHuellaTotal2(Medible medible, FachadaPosta fachadaPosta) throws IOException {
		Assertions.assertEquals(35, procesadorHC.calculoHCTotal(medible, fachadaPosta));
	}

	@Test
	public void unaOrganizacionNoPuedeVincularUnSectorNoPostulado(){
		Assertions.assertThrows(MiembroNoPostuladoException.class, ()->{organizacion1.aceptarVinculacionConMiembro(miembro);});
	}
}
