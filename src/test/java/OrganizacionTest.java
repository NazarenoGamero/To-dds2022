import dds.grupo3.clases.organizacion.Sector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.organizacion.Clasificacion;
import dds.grupo3.clases.organizacion.TipoOrg;
import dds.grupo3.clases.readers.MedicionCSV;
import dds.grupo3.clases.exception.MiembroNoPostuladoException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.fachada.FachadaPosta;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.organizacion.Organizacion;

public class OrganizacionTest {
	Organizacion organizacion1;
	Organizacion organizacion2;
	Sector sector1;
	Sector sector2;
	Miembro miembro;
	List<Sector> sectores = new ArrayList<>();

	FachadaPosta fachada;
	MedicionCSV reader = new MedicionCSV();
	String path = System.getProperty("user.dir") + "/src/files/" + "/mediciones.CSV";

	@BeforeEach
	private void inicializarOrganizacion() {
		organizacion1 = new Organizacion("LaUni", new TipoOrg("INSTITUCION"), sectores,
				new Clasificacion("UNIVERSIDAD"));
		organizacion2 = new Organizacion("LaUni", new TipoOrg("INSTITUCION"), sectores,
				new Clasificacion("UNIVERSIDAD"));
		sector1 = new Sector("sector1");
		sector2 = new Sector("sector2");
		miembro = new Miembro("Juan", "Pirulito", TipoDocEnum.DNI, 43858878);
	}

	@Test
	public void unSectorNoPuedePertenecerAdosOrg(){
		organizacion1.agregarSector(sector1);
		Assertions.assertThrows(YaPerteneceOrgException.class, () -> {
			organizacion2.agregarSector(sector1);
		});
	}

	@Test
	public void calculoHuellaTotal() throws IOException{
		Assertions.assertEquals(35, organizacion1.calcularHuellaDeCarbonoST(reader.leerArchivoMediciones(path)));
	}

	@Test
	public void unaOrganizacionNoPuedeVincularUnSectorNoPostulado() {
		Assertions.assertThrows(MiembroNoPostuladoException.class, () -> {
			organizacion1.aceptarVinculacionConMiembro(miembro);
		});
	}
}
