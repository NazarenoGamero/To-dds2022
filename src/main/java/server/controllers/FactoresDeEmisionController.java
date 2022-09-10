package server.controllers;

import com.google.gson.Gson;
import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.repositorios.RepoFactoresDeEmision;
import dds.grupo3.clases.repositorios.RepoMediciones;
import java.util.Objects;
import java.util.Properties;
import spark.Request;
import spark.Response;

public class FactoresDeEmisionController {
  private RepoFactoresDeEmision repo;

  public FactoresDeEmisionController (RepoFactoresDeEmision repo) {
    this.repo=repo;
  }


  public String modificar(Request request, Response response) {
    Gson gson = new Gson();
    Properties prop= gson.fromJson(request.body(), Properties.class);
    if(prop.getProperty("value")== null){
      response.status(400);
      return "Campo value vacío";
    }
    Float value= Float.parseFloat(prop.getProperty("value"));
    FactorEmision fe= repo.encontrarPorId(Long.parseLong(request.params(":id")));
    if(fe==null){
      response.status(404);
      return "Factor de Emision no encontrado";
    }
    fe.setValor(value);
    response.status(200);
    response.type("application/json");
    return gson.toJson(fe).toString();
  }
}
