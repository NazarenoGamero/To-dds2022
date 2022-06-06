package dds.grupo3.clases.trayectos;

import java.util.Set;

public class Linea {
    private String nombreLinea;
    private Set<Parada> paradas;

    public Linea(String nombreLinea, Set<Parada> paradas) {
        this.nombreLinea = nombreLinea;
        this.paradas = paradas;
    }

	public String getNombreLinea() {
		return nombreLinea;
	}

	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}

	public Set<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(Set<Parada> paradas) {
		this.paradas = paradas;
	}
}