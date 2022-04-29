package dds.grupo3.clases;

import java.util.HashMap;
import java.util.Map;

//quise hacer un switch pero muy largo e innecesario
//pense en una interface por la cuestion de poder modificarlo pero al no tener logica otra vez es innecesario
//entonces elegi un hashMap(diccionario) que es mejor q un enum por que se le puede agregar y modificar elementos en tiempo de ejecucion
public class FE {
    Map<String, Integer> diccFE = new HashMap<>();
    public void main(String[] args){
        diccFE.put("Gas Natural",0 );
        diccFE.put("Diesel/Gasoil",0);
        diccFE.put("Kerosene",0);
        diccFE.put("Fuel Oil",0);
        diccFE.put("Nafta",0);
        diccFE.put("Carbón",0);
        diccFE.put("Carbón de leña",0);
        diccFE.put("Leña",0);
        diccFE.put("Combustible consumido - Gasoil",0);
        diccFE.put("Combustible consumido – GNC",0);
        diccFE.put("Combustible consumido - Nafta",0);
        diccFE.put("Electricidad",0);
    }

    public Integer convertirUnidad(String tipoConsumo){
        try {
            if(diccFE.get(tipoConsumo) != NULL) {
                return diccFE.get(tipoConsumo);
            }else{
                throw new NotFoundException();
            }
        }
        catch(Exception e){
            System.out.printIn(e);
        }
        return null;
    }

    public void cambiarFE(tipoConsumo,fe){

    }

    public void agregarFE(tipoConsumo,fe){

    }
}

