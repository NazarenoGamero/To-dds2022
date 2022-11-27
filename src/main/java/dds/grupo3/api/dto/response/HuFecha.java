package dds.grupo3.api.dto.response;

import java.time.Month;

import dds.grupo3.clases.medible.Medible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HuFecha {
	
	private int anio;
	private String mes;
	private float valor;
	
	public HuFecha(Medible unMedible) {
		anio =  unMedible.getFecha().getYear();
		mes = Month.of(unMedible.getFecha().getMonth()).name();
		//Para que traiga el factor de emision correspondiente de la DB hago un get
		unMedible.getMiFactor();
		valor = unMedible.obtenerHuella();
	}
}
