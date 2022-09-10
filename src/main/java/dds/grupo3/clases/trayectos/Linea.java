package dds.grupo3.clases.trayectos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Linea {
    private String nombre;
    private Set<Parada> paradas;
}