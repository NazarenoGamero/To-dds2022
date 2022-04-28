package dds.grupo3.clases;

public class Medible {
	private TipoDeActividad actividad;
	private TipoDeConsumo tipoDeConsumo;
	private int valor;
	private Unidad unidad;
	private Periodicidad periodicidad;
	private Alcance alcance;

	// Constructor

	public Medible(TipoDeActividad actividad, TipoDeConsumo tipoDeConsumo, Unidad unidad, int valor,
			Periodicidad periodicidad, Alcance alcance) {
		this.actividad = actividad;
		this.tipoDeConsumo = tipoDeConsumo;
		this.valor = valor;
		this.unidad = unidad;
		this.periodicidad = periodicidad;
		this.alcance = alcance;
	}

	// Setters y Getters

	public TipoDeActividad getActividad() {
		return actividad;
	}

	public void setActividad(TipoDeActividad actividad) {
		this.actividad = actividad;
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Periodicidad getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(Periodicidad periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Alcance getAlcance() {
		return alcance;
	}

	public void setAlcance(Alcance alcance) {
		this.alcance = alcance;
	}

}