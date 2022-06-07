package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.clases.miembro.Impresiones;
import dds.grupo3.clases.miembro.Miembro;

public class Sector {
	public Organizacion organizacion;
	private String nombre;
	private List<Miembro> miembros;

	public List<Impresiones> getHistorialImpresiones() {
		return historialImpresiones;
	}

	public void setHistorialImpresiones(List<Impresiones> historialImpresiones) {
		this.historialImpresiones = historialImpresiones;
	}

	private List<Impresiones> historialImpresiones;

	public float clacularMiHuella() {
		return ((float) miembros.stream().mapToDouble(mi -> mi.calcularHU()).sum()) + ((float)  historialImpresiones.stream().mapToDouble(imp -> imp.miConsumo()).sum());
	}
	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public Sector(String nombre) {
		super();
		this.nombre = nombre;
		this.organizacion = null;
		this.miembros = new ArrayList<Miembro>();
	}

	public void agregarMiembro(Miembro miembro) {
		miembros.add(miembro);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Miembro> getMiembros() {
		return miembros;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}
}