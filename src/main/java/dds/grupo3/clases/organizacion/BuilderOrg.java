package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;

public class BuilderOrg {
	List<TipoOrg> tiposOrg;
	List<Clasificacion> clasificaciones;
	
	public Organizacion crearOrg() {
		return new Organizacion();
	}
	
	
	public void Inicializar() {
		this.getTiposOrg().add(new TipoOrg("Gubernamental"));
		this.getTiposOrg().add(new TipoOrg("ONG"));
		this.getTiposOrg().add(new TipoOrg("Empresa"));
		this.getTiposOrg().add(new TipoOrg("Institucion"));
		this.getClasificaciones().add(new Clasificacion("Ministerio"));
		this.getClasificaciones().add(new Clasificacion("Universidad"));
		this.getClasificaciones().add(new Clasificacion("Escuela"));
		this.getClasificaciones().add(new Clasificacion("Empresa del sector primario"));
		this.getClasificaciones().add(new Clasificacion("Empresa del sector secundario"));
	}
	
	public BuilderOrg() {
		this.tiposOrg = new ArrayList<TipoOrg>();
		this.clasificaciones = new ArrayList<Clasificacion>();
	}


	public List<TipoOrg> getTiposOrg() {
		return tiposOrg;
	}


	public void setTiposOrg(List<TipoOrg> tiposOrg) {
		this.tiposOrg = tiposOrg;
	}


	public List<Clasificacion> getClasificaciones() {
		return clasificaciones;
	}


	public void setClasificaciones(List<Clasificacion> clasificaciones) {
		this.clasificaciones = clasificaciones;
	}
}
