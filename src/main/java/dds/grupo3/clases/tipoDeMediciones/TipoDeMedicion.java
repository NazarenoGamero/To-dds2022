package dds.grupo3.clases.tipoDeMediciones;

import java.util.List;

import dds.grupo3.clases.organizacion.Clasificacion;

public class TipoDeMedicion {
	private String tipoDeactividad;
	private String tipoDeConsumo;
	private Unidad unidad;
	private String alcance;
	private List<Clasificacion> clasificaciones;

	// Constructor

	public TipoDeMedicion(String tipoDeactividad, String tipoDeConsumo, Unidad unidad,
			String alcance, List<Clasificacion> clasificaciones) {
		this.tipoDeactividad = tipoDeactividad;
		this.tipoDeConsumo = tipoDeConsumo;
		this.unidad = unidad;
		this.alcance = alcance;
		this.clasificaciones= clasificaciones;
	}

	/*
	 * Ver forma para que resuelva y sepa asociar que cuando es combustion fija por
	 * ejemplo de gas natural, la unidad sea m3 y el alcance de 1: Emisiones
	 * directas
	 */

	// Setters y Getters

	public String getActividad() {
		return tipoDeactividad;
	}

	public void setActividad(String actividad) {
		this.tipoDeactividad = actividad;
	}

	public String getTipoDeConsumo() {
		return tipoDeConsumo;
	}

	public void setTipoDeConsumo(String tipoDeConsumo) {
		this.tipoDeConsumo = tipoDeConsumo;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public boolean tipoDeActividadValido(Clasificacion clasificacion) {
		return this.clasificaciones.contains(clasificacion);
	}

}
