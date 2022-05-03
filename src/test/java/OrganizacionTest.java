import dds.grupo3.clases.Exception.MiembroNoPostuladoException;
import dds.grupo3.clases.FachadaPosta;
import dds.grupo3.clases.MedicionCSV;
import dds.grupo3.clases.Miembro;
import dds.grupo3.clases.ParametrosReader;
import dds.grupo3.clases.Sector;
import dds.grupo3.clases.Exception.YaPerteneceOrgException;

import static dds.grupo3.clases.TipoDocEnum.DNI;
import dds.grupo3.clases.organizacion.Organizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dds.grupo3.clases.organizacion.Clasificacion.UNIVERSIDAD;
import static dds.grupo3.clases.organizacion.Tipo.INSTITUCION;

public class OrganizacionTest {
	Organizacion organizacion1;
	Organizacion organizacion2;
	Sector sector1;
	Sector sector2;
	Miembro miembro;
	List<Sector> sectores = new ArrayList<>();

	FachadaPosta fachada;
	MedicionCSV readercsv = new MedicionCSV();
	ParametrosReader readerFE = new ParametrosReader();
	String mediciones = System.getProperty("user.dir") + "/src/files/" + "/mediciones.CSV";
	String parametros = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";

	@BeforeEach
	private void inicializarOrganizacion() throws IOException {
		fachada= FachadaPosta.getInstance();
		organizacion1 = new Organizacion("LaUni", INSTITUCION, sectores, UNIVERSIDAD);
		organizacion2 = new Organizacion("LaUni", INSTITUCION, sectores, UNIVERSIDAD);
		sector1 = new Sector("sector1");
		sector2 = new Sector("sector2");
		miembro = new Miembro("Juan", "Pirulito", DNI, 43858878);
	}

	@Test
	public void unSectorNoPuedePertenecerAdosOrg() throws YaPerteneceOrgException {
		organizacion1.agregarSector(sector1);
	    Assertions.assertThrows(YaPerteneceOrgException.class, ()->{organizacion2.agregarSector(sector1);});
	}

	@Test
	public void calculoHuellaTotal() throws IOException {
		fachada = FachadaPosta.getInstance();
		fachada.cargarParametros(readerFE.leerParametros(parametros));
		Assertions.assertEquals(35, organizacion1.calcularHuellaDeCarbonoST(mediciones));
	}

	@Test
	public void unaOrganizacionNoPuedeVincularUnSectorNoPostulado(){
		Assertions.assertThrows(MiembroNoPostuladoException.class, ()->{organizacion1.aceptarVinculacionConMiembro(miembro);});
	}
	
}
