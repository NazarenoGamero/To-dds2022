package dds.grupo3.clases;

import dds.grupo3.clases.organizacion.Organizacion;

public class Miembro {
	private String nombre;
	private String apellido;
	private TipoDocEnum tipoDoc;
	private int nroDoc;

	// Constructor
	public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, int nroDoc) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDocEnum getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocEnum tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public void postularme(Organizacion organizacion){organizacion.nuevoPostulado(this);}

	public boolean pertenescoEmpresa() {
		//TODO
	}

	public boolean pertenescoONGorGubernamental() {
		//TODO
	}

	public int cantidadEmpresasPertenesco() {
		//TODO
	}
}
