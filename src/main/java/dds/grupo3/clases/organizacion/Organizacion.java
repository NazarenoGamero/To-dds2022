package dds.grupo3.clases.organizacion;

import dds.grupo3.clases.*;
import dds.grupo3.clases.Exception.MiembroNoPostuladoException;
import dds.grupo3.clases.Exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.Exception.YaPerteneceOrgException;
import dds.grupo3.clases.Exception.MiembroNoVinculadoException;
import dds.grupo3.clases.organizacion.Tipo.Tipo;
import dds.grupo3.clases.organizacion.Tipo.TipoOrg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
	private String razonSocial;
	private TipoOrg tipo;
	private List<Sector> sectores;
	private Clasificacion clasificacion;
	private List<Medible> mediciones = new ArrayList<Medible>();

	public List<Miembro> getPostulados() {
		return postulados;
	}

	private List<Miembro> postulados;

	public List<Miembro> getMiembrosVinculados() {
		return miembrosVinculados;
	}

	private List<Miembro> miembrosVinculados;
	private MedicionesReader reader;

	public Organizacion(String razonSocial, TipoOrg tipo, List<Sector> unSector, Clasificacion unaClasificaion) {
		this.razonSocial = razonSocial;
		this.sectores = new ArrayList<Sector>();
		this.clasificacion = clasificacion;
		this.postulados= new ArrayList<>();
		this.miembrosVinculados= new ArrayList<>();
		this.reader= new MedicionCSV();
	}
	
	
	
	public void cargarMediciones(String path){
		mediciones.addAll(reader.leerArchivoMediciones(path));
	}

	/* agregar estas funciones mas tarde */
	public void aceptarVinculacionMiembro(Miembro miembro){
		if(this.validarVinculacionConMiembro(miembro)){
			this.vincularMiembro(miembro);
		}
	}

	private boolean validarVinculacionConMiembro(Miembro miembro) {
		return tipo.validar(miembro,this);
	}

	public void vincularMiembro(Miembro miembro){
		postulados.remove(miembro);
		miembrosVinculados.add(miembro);
	}
	public void agregarMiembroSector(Sector sector,Miembro miembro) throws SectorNoPerteneceOrgException {
		if (!sectores.contains(sector)) {
			throw new SectorNoPerteneceOrgException("El sector no pertenece a la organizacion");
		}
		if(!miembrosVinculados.contains(miembro)){
			throw new MiembroNoVinculadoException("El miembro no esta vinculado.");
		}
		else{
			sector.agregarMiembro(miembro);
		}
	}

	public float calcularHuellaDeCarbonoST(List<Medible> unasMediciones) throws IOException {
        FachadaPosta unaFachada = new FachadaPosta();
        ParametrosReader reader = new ParametrosReader();
        String path = System.getProperty("user.dir") + "/src/files/" + "/parametros.txt";
        unaFachada.cargarParametros(reader.leerParametros(path));
        return unaFachada.obtenerHU(unasMediciones);
    }
	// añade un postulado a la lista
	public void nuevoPostulado(Miembro miembro){this.postulados.add(miembro);}

	public void agregarSector(Sector sector) throws YaPerteneceOrgException {

		if (sector.getOrganizacion() != null) {
			throw new YaPerteneceOrgException();
		} else {
			this.sectores.add(sector);
			sector.setOrganizacion(this);
			
		}

	}

	public List<Miembro> getMiembros() {
		return miembrosVinculados;
	}
}
