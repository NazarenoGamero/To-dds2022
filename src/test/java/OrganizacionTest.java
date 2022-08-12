/*
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
*/