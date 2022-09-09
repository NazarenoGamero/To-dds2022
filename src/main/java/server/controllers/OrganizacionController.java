package server.controllers;

import com.google.gson.Gson;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import java.util.List;
import java.util.Objects;
import spark.Request;
import spark.Response;

public class OrganizacionController {
  private RepoOrganizaciones repo;

  public OrganizacionController(RepoOrganizaciones repo) {
    this.repo = repo;
  }

  public List<Organizacion> list(Request request, Response response) {
    List<Organizacion> organizaciones = repo.getOrganizaciones();
    return organizaciones;
  }

  public Organizacion add(Request request, Response response) {
    Gson gson = new Gson();
    Organizacion organizacion = gson.fromJson(request.body(), Organizacion.class);
    this.repo.agregar(organizacion);
    response.status(201); // 201 Created
    return organizacion;
  }

  /*
  public  Organizacion change(Request request, Response response) {
  }
   */
  //Esto tiene que cambiar por un id
  public String delete(Request request, Response response) {
    Long id = Long.parseLong(request.params(":id"));
    repo.eliminarPorId(id);
    return "DELETED";
  }

  public Organizacion get(Request request, Response response) {
    Long id = Long.parseLong(request.params(":id"));
    return repo.encontrarPorId(id);
  }

  public Organizacion change(Request request, Response response) {
    Gson gson = new Gson();
    Organizacion orgUpdt = gson.fromJson(request.body(), Organizacion.class);
    Organizacion organizacion= repo.encontrarPorId(Long.parseLong(request.params(":id")));
    organizacion.setRazonSocial(orgUpdt.getRazonSocial());
    organizacion.setTipo(orgUpdt.getTipo());
    organizacion.setSectores(orgUpdt.getSectores());
    organizacion.setClasificacion(orgUpdt.getClasificacion());
    response.status(200); // 200 update
    return organizacion;
  }
}
