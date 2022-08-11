package Server.Controllers;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.TipoOrg;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import spark.Request;
import spark.Response;
import java.util.ArrayList;
import java.util.List;

public class OrganizacionController {
  private RepoOrganizaciones repo;

  public OrganizacionController(RepoOrganizaciones repo) {
    this.repo = repo;
  }

  public List<Organizacion> list(Request request, Response response) {
    List<Organizacion> organizaciones= new ArrayList<Organizacion>();
    return organizaciones;
  }

  public Object add(Request request, Response response) {
  }

  public  Object change(Request request, Response response) {
  }

  public  Object delete(Request request, Response response) {
  }
}
