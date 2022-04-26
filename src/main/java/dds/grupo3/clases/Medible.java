package dds.grupo3.clases;

public class Medible {
    private String actividad;
    private String tipoDeConsumo;
    private Unidad unidad;
    private int valor;
    private int periodicidad;
    private Alcance alcance;

    // Constructor

    public Medible(String actividad, String tipoDeConsumo, Unidad unidad, int valor, int periodicidad, Alcance alcance) {
        super();
        this.actividad = actividad;
        this.tipoDeConsumo = tipoDeConsumo;
        this.unidad = unidad;
        this.valor = valor;
        this.periodicidad = periodicidad;
        this.alcance = alcance;
    }

    // Setters y Getters

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Alcance getAlcance() {
        return alcance;
    }

    public void setAlcance(Alcance alcance) {
        this.alcance = alcance;
    }

    //Calcula el Dato de Actividad
	public Float getDA() {
		// TODO implementar
		return null;
	}
}