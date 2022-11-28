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
	
	//Hago override del equals para poder manejar mejor dos objetos muy parecidos (Son iguales aunque el campo "valor" sea distinto
	@Override
	public boolean equals(Object otro) {
		// Me fijo si el otro objeto no es el mismo exacto
		if (otro == this) {
            return true;
        }
 
        //Me fijo que no sea de otro tipo
        if (!(otro instanceof HuFecha)) {
            return false;
        }
        
        //Casteo para poder llamar a sus metodos
        HuFecha otroCasteado = (HuFecha) otro;
        //Verifico los campos
		return (this.getAnio() == otroCasteado.getAnio()) && (this.getMes().equals(otroCasteado.getMes()));
	}
}
