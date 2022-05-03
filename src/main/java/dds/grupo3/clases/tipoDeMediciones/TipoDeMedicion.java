package dds.grupo3.clases.tipoDeMediciones;

import java.util.List;

import dds.grupo3.clases.organizacion.Clasificacion;

public class TipoDeMedicion {
	private TipoDeActividad tipoDeactividad;
	private TipoDeConsumo tipoDeConsumo;
	private Unidad unidad;
	private Alcance alcance;
	private List<Clasificacion> clasificaciones;

	// Constructor

	public TipoDeMedicion(TipoDeActividad tipoDeactividad, TipoDeConsumo tipoDeConsumo, Unidad unidad,
			Alcance alcance, List<Clasificacion> clasificaciones) {
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

	public TipoDeActividad getActividad() {
		return tipoDeactividad;
	}

	public void setActividad(TipoDeActividad actividad) {
		this.tipoDeactividad = actividad;
	}

	public TipoDeConsumo getTipoDeConsumo() {
		return tipoDeConsumo;
	}

	public void setTipoDeConsumo(TipoDeConsumo tipoDeConsumo) {
		this.tipoDeConsumo = tipoDeConsumo;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Alcance getAlcance() {
		return alcance;
	}

	public void setAlcance(Alcance alcance) {
		this.alcance = alcance;
	}

	public boolean tipoDeActividadValido(Clasificacion clasificacion) {
		return this.clasificaciones.contains(clasificacion);
	}

}
