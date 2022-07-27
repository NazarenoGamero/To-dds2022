import dds.grupo3.clases.organizacion.Sector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dds.grupo3.clases.organizacion.Clasificacion;
import dds.grupo3.clases.organizacion.TipoOrg;
import dds.grupo3.clases.CalculadorHU;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.organizacion.Organizacion;

public class OrganizacionTest {
	List<Sector> sectores = new ArrayList<>();
	Organizacion organizacion1 = new Organizacion("LaUni", new TipoOrg("INSTITUCION"), sectores,
			new Clasificacion("UNIVERSIDAD"));
	Organizacion organizacion2 =  new Organizacion("LaUni", new TipoOrg("INSTITUCION"), sectores,
			new Clasificacion("UNIVERSIDAD"));
	Sector sector1 = new Sector("sector1");
	Sector sector2 = new Sector("sector2");
	Miembro miembro = new Miembro("Juan", "Pirulito", TipoDocEnum.DNI, 43858878);
	
	String[] path =new String[] {"-p","./src/files/parametros.txt","-m","./src/files/mediciones.csv"};


	@Test
	public void unSectorNoPuedePertenecerAdosOrg(){
		organizacion1.agregarSector(sector1);
		assertThrows(YaPerteneceOrgException.class, () -> {
			organizacion2.agregarSector(sector1);
		});
	}

	@Test
	public void calculoHuellaTotal() throws IOException{
		assertEquals(35, CalculadorHU.main(path));
	}

	@Test
	public void unMiembroSePostula() {
		organizacion1.agregarSector(sector1);
		miembro.postularme(organizacion1, sector1);
		organizacion1.aceptarPostulacion();
		assertTrue(organizacion1.miembrosOrg().contains(miembro));
	}
}
