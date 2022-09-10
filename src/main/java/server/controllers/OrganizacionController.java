package server.controllers;

import com.google.gson.Gson;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.repositorios.RepoMiembros;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import org.json.simple.JSONObject;
import spark.Request;
import spark.Response;

public class OrganizacionController {
  private RepoOrganizaciones repoOrganizaciones;
  private RepoMiembros repoMiembros;

  public OrganizacionController(RepoOrganizaciones repoO, RepoMiembros repoM) {
    this.repoOrganizaciones = repoO;
    this.repoMiembros= repoM;
  }

  public List<Organizacion> list(Request request, Response response) {
    List<Organizacion> organizaciones = repoOrganizaciones.getOrganizaciones();
    response.type("application/json");
    return organizaciones;
  }

  public Organizacion add(Request request, Response response) {
    Gson gson = new Gson();
    Organizacion organizacion = gson.fromJson(request.body(), Organizacion.class);
    this.repoOrganizaciones.agregar(organizacion);
    response.status(201); // 201 Created
    response.type("application/json");
    return organizacion;
  }

  /*
  public  Organizacion change(Request request, Response response) {
  }
   */
  //Esto tiene que cambiar por un id
  public String delete(Request request, Response response) {
    Long id = Long.parseLong(request.params(":id"));
    repoOrganizaciones.eliminarPorId(id);
    return "DELETED";
  }

  public Organizacion get(Request request, Response response) {
    Long id = Long.parseLong(request.params(":id"));
    response.type("application/json");
    return repoOrganizaciones.encontrarPorId(id);
  }

  public Organizacion change(Request request, Response response) {
    Gson gson = new Gson();
    Organizacion orgUpdt = gson.fromJson(request.body(), Organizacion.class);
    Organizacion organizacion= repoOrganizaciones.encontrarPorId(Long.parseLong(request.params(":id")));
    organizacion.setRazonSocial(orgUpdt.getRazonSocial());
    organizacion.setTipo(orgUpdt.getTipo());
    organizacion.setSectores(orgUpdt.getSectores());
    organizacion.setClasificacion(orgUpdt.getClasificacion());
    response.status(200); // 200 update
    response.type("application/json");
    return organizacion;
  }

  public String assignMember(Request request, Response response) {
    Gson gson=new Gson();
    Properties prop= gson.fromJson(request.body(), Properties.class);
    Long idMiembro= Long.parseLong(prop.getProperty("idMiembro"));
    String sector=prop.getProperty("sector");
    Long idOrganizacion= Long.parseLong(request.params(":id"));
    Miembro miembro= repoMiembros.encontrarPorId(idMiembro);
    if(miembro!=null){
      Optional<Sector> first= repoOrganizaciones.encontrarPorId(idOrganizacion).getSectores()
          .stream().filter(x-> x.getNombre().equals(sector)).findFirst();
      if(first.isPresent())
       first.get().agregarMiembro(miembro);
      else
        response.status(400); //bad request
    }
    else
      response.status(400); //bad request
    return "";
  }
}
