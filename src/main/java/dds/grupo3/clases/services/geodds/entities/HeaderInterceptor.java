package dds.grupo3.clases.services.geodds.entities;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HeaderInterceptor implements Interceptor {

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request()
        .newBuilder()
        .addHeader("Authorization", "Bearer " + "2gSCEk8R7REUaVp5KuT6S2GxOo8dauKwuxuMJDQw8JA=")
        .build();
    Response response = chain.proceed(request);
    return response;
  }
}