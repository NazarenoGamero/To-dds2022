import dds.grupo3.clases.services.geodds.ServicioGeodds;
import dds.grupo3.clases.services.geodds.entities.Distancia;
import dds.grupo3.clases.services.geodds.entities.Localidad;
import dds.grupo3.clases.services.geodds.entities.Municipio;
import dds.grupo3.clases.services.geodds.entities.Pais;
import dds.grupo3.clases.services.geodds.entities.Provincia;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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

  @Test
  public void devuelveMunicipioDeUnaProvicia() throws IOException {
    ServicioGeodds servicioGeodds = ServicioGeodds.instancia();
    List<Municipio> municipios = servicioGeodds.listadoDeMunicipio(2, 168);
    Assertions.assertFalse(municipios.stream().filter(m -> m.nombre.contentEquals("HURLINGHAM"))
        .collect(Collectors.toList()).isEmpty());
  }

  @Test
  public void devuelveLocalidadDeUnMunicipio() throws IOException {
    ServicioGeodds servicioGeodds = ServicioGeodds.instancia();
    List<Localidad> localidades = servicioGeodds.listadoDeLocalidades(1, 369); //Florencio Varela
    Assertions.assertFalse(
        localidades.stream().filter(m -> m.nombre.contentEquals("ESTANISLAO SEVERO ZEBALLOS"))
            .collect(Collectors.toList()).isEmpty());
  }

  @Test
  public void calcularDistancia() throws IOException {
    ServicioGeodds servicioGeodds = ServicioGeodds.instancia();
    Distancia distancia = servicioGeodds.distancia(1, "maipu", "100"
        , 457, "O'Higgins", "200");
    Assertions.assertNotNull(
        distancia.unidad);  //la distancia que calcula la api cambia cada vez que es calculada con los mismos parametros
    Assertions.assertEquals(distancia.unidad, "KM");
  }

}
