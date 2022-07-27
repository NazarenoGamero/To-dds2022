package dds.grupo3.clases.services.geodds;
import com.sun.org.apache.xalan.internal.xsltc.dom.MultipleNodeCounter;
import dds.grupo3.clases.services.geodds.entities.*;
import jdk.nashorn.internal.ir.LiteralNode;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;


public class ServicioGeodds {
  //Aguante el Singleton vieja!
  private static ServicioGeodds instancia = null;
  private static final String URLAPI = "https://ddstpa.com.ar/api/";
  private Retrofit retrofit;
  private String TOKEN = "2gSCEk8R7REUaVp5KuT6S2GxOo8dauKwuxuMJDQw8JA=";

  private ServicioGeodds() {
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new HeaderInterceptor()).build();

    this.retrofit = new Retrofit.Builder()
        .client(client)
        .baseUrl(URLAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ServicioGeodds instancia() {
    if (instancia == null) {
      instancia = new ServicioGeodds();
    }
    return instancia;
  }

  public List<Pais> listadoDePaises(int offset) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Pais>> requestPaises = geoddsService.paises(offset);  //Offset debe ser >1
    Response<List<Pais>> responsePaises = requestPaises.execute();
    return responsePaises.body();
  }

  public List<Provincia> listadoDeProvincias(int offset) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Provincia>> requestListadoDeProvincias = geoddsService.provincias(offset);
    Response<List<Provincia>> responseListadoDeMunicipios = requestListadoDeProvincias.execute();
    return responseListadoDeMunicipios.body();
  }

  public List<Provincia> listadoDeProvincias(int offset, int paisId) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Provincia>> requestListadoDeProvincias = geoddsService.provincias(offset,paisId);
    Response<List<Provincia>> responseListadoDeMunicipios = requestListadoDeProvincias.execute();
    return responseListadoDeMunicipios.body();
  }

  public List<Municipio> listadoDeMunicipio(int offset) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Municipio>> requestListadoDeMunicipios= geoddsService.municipios(offset);
    Response<List<Municipio>> responseListadoDeMunicipios= requestListadoDeMunicipios.execute();
    return responseListadoDeMunicipios.body();
  }

  public List<Municipio> listadoDeMunicipio(int offset, int provinciaId) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Municipio>> requestListadoDeMunicipios= geoddsService.municipios(offset,provinciaId);
    Response<List<Municipio>> responseListadoDeMunicipios= requestListadoDeMunicipios.execute();
    return responseListadoDeMunicipios.body();
  }

  public List<Localidad> listadoDeLocalidades(int offset) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Localidad>> requestListadoDeLocalidades= geoddsService.localidades(offset);
    Response<List<Localidad>> responseListadoDeLocalidades= requestListadoDeLocalidades.execute();
    return responseListadoDeLocalidades.body();
  }

  public List<Localidad> listadoDeLocalidades(int offset, int municipioId) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Localidad>> requestListadoDeLocalidades= geoddsService.localidades(offset,municipioId);
    Response<List<Localidad>> responseListadoDeLocalidades= requestListadoDeLocalidades.execute();
    return responseListadoDeLocalidades.body();
  }

  public Distancia distancia(int localidadOrigenId,String calleOrigen,String alturaOrigen
                            ,int localidadDestinoId, String calleDestino
                            ,String alturaDestino) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<Distancia> requestDistancia= geoddsService.distancia(localidadOrigenId,calleOrigen, alturaOrigen
                                                            ,localidadDestinoId,calleDestino,alturaDestino);
    Response<Distancia> responseDistancia= requestDistancia.execute();
    return responseDistancia.body();
  }
}
