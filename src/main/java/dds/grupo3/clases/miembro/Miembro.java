package dds.grupo3.clases.miembro;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.trayectos.Tramo;
import dds.grupo3.clases.trayectos.Trayecto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Miembro {
	private String nombre;
	private String apellido;
	private TipoDocEnum tipoDoc;
	private int nroDoc;
	private List<Trayecto> trayectos;
	private Set<Empleo> empleos;

	// Constructor
	public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, int nroDoc, Set<Empleo> empleos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.empleos = empleos;
	}

	public void setUnTrayecto(List<Trayecto> unTrayecto) {
		this.trayectos = unTrayecto;
	}
	public void agregarUnTrayecto (Trayecto unTrayecto){ trayectos.add(unTrayecto); }

	public int calcularHU(){
		return trayectos.stream().mapToInt(t -> t.calcularHU()).sum();
	}

	public List<int> calcularHUPorcentual(){
		//empleos
		//TODO tenemos que definir como hace el miembro para saber el HU de la org
		return null;
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

	public void postularme(Organizacion organizacion, Sector sector){
	organizacion.nuevoPostulado(this, sector);
	}

	public void nuevoEmpleo(Organizacion organizacion, Sector sector) {
		empleos.add(new Empleo(organizacion,sector));
	}
}
