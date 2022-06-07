package dds.grupo3.clases.trayectos;

import dds.grupo3.clases.miembro.Miembro;

import java.util.List;
import java.util.stream.DoubleStream;

public class Trayecto implements Recorrido {
    private List<Recorrido> recorrido;


    public Trayecto(List<Recorrido> recorridos) {
        this.recorrido = recorridos;
    }
/*
    public void setUnosMiembros(List<Miembro> unosMiembros) {
        this.unosMiembros = unosMiembros;
    }
    
    public float distantiaTotal(){
        return (float)unosTramos.stream().mapToDouble(unTramo -> unTramo.distanciaTramo(unTramo.getUnTransporte())).sum();
    }

    public float calcularHU(){
        return 0;
    }
*/
    @Override
    public float distancia() {
        return (float)recorrido.stream().mapToDouble(unRecorrido -> unRecorrido.distancia()).sum();
    }

}
