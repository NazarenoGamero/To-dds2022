package dds.grupo3.clases.Medible;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;

import java.util.Date;

public class Medible {
	private TipoDeMedicion tipoDeMedicion;
	private int valor;
	private Periodicidad periodicidad;
	private Date PeriodoDeImputacion;

	// Constructor

	public Medible(TipoDeMedicion tipoDeMedicion, int valor, Periodicidad periodicidad, Date periodoDeImputacion) {
		this.tipoDeMedicion = tipoDeMedicion;
		this.valor = valor;
		this.periodicidad = periodicidad;
		this.PeriodoDeImputacion = periodoDeImputacion;
	}

	// Setters y Getters

	public TipoDeMedicion getTipoDeMedicion() {
		return tipoDeMedicion;
	}

	public void setTipoDeMedicion(TipoDeMedicion tipoDeMedicion) {
		this.tipoDeMedicion = tipoDeMedicion;
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
}