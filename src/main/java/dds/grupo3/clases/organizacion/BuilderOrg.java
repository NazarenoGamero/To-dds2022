package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.clases.medible.FactorEmision;

public class BuilderOrg {
	List<TipoOrg> tiposOrg;
	List<Clasificacion> clasificaciones;
	
	public Organizacion crearOrg() {
		//TODO Aca agregar todo para que se cree una organizacion default
	}
	
	
	public void Inicializar() {
		//TODO Se crean todos los tipos de organizacion y clasificaciones
	}
	
	public BuilderOrg() {
		this.tiposOrg = new ArrayList<TipoOrg>();
		this.clasificaciones = new ArrayList<Clasificacion>();
	}
}
