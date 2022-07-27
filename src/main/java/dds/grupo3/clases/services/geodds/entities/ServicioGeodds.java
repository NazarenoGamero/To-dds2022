package dds.grupo3.clases.services.geodds.entities;
import dds.grupo3.clases.services.geodds.GeoddsService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);    //le indico a retrofit que me cree un objeto que implemente la interfaz GeorefService
    Call<List<Pais>> requestPaises = geoddsService.paises(offset);  //Offset debe ser >1
    Response<List<Pais>> responsePaises = requestPaises.execute();
    return responsePaises.body();
  }

  public List<Provincia> listadoDeDeProvincias(int offset, int paisId) throws IOException {
    GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
    Call<List<Provincia>> requestListadoDeProvincias = geoddsService.provincias(offset,paisId);
    Response<List<Provincia>> responseListadoDeMunicipios = requestListadoDeProvincias.execute();
    return responseListadoDeMunicipios.body();
  }
}
