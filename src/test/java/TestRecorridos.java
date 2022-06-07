import dds.grupo3.clases.trayectos.*;
import org.junit.jupiter.api.Test;

public class TestRecorridos {
    Punto punto1 = new Punto (0,1);
    Punto punto2 = new Punto(1,1);
    Punto punto3 = new Punto(1,0);
    Punto punto4 = new Punto (10,10);


    Parada paradaConstitucion = new Parada("Contitucion",punto4,paradaRetiro,paradaObelisco);
    Parada paradaRetiro = new Parada("Rerito",punto2,paradaObelisco,paradaConstitucion);
    Parada paradaObelisco = new Parada("Obelisco",punto3,paradaConstitucion,paradaRetiro);


    TransportePublico elChiquitoBus = new TransportePublico("Ford",);
    Tramo tramo1 = new Tramo(, )
    Trayecto unTrayecto = new Trayecto();


}
