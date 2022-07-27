import dds.grupo3.clases.services.geodds.entities.Pais;
import dds.grupo3.clases.services.geodds.entities.Provincia;
import dds.grupo3.clases.services.geodds.ServicioGeodds;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;

public class GeoddsTest {

  @Test
  public void devuelvePais() throws IOException {
    ServicioGeodds servicioGeodds = ServicioGeodds.instancia();
    List<Pais> paises = servicioGeodds.listadoDePaises(1);
    Assertions.assertEquals(9, paises.get(0).id);
  }

  @Test
  public void devuelveProvincias() throws IOException {
    ServicioGeodds servicioGeodds = ServicioGeodds.instancia();
    List<Provincia> provincias = servicioGeodds.listadoDeProvincias(1, 9);
    Assertions.assertEquals("BUENOS AIRES", provincias.get(0).nombre);
  }

}
