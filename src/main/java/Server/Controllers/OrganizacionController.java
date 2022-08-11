package Server.Controllers;

import dds.grupo3.clases.organizacion.Organizacion;
import spark.Request;
import spark.Response;

public class OrganizacionController {
  private RepoOrganizaciones repo;

  public OrganizacionController(RepoOrganizaciones repo) {
    this.repo = repo;
  }

  public static List<Organizacion> list(Request request, Response response) {
    return null;
  }

  public static Object add(Request request, Response response) {
  }

  public static Object change(Request request, Response response) {
  }

  public static Object delete(Request request, Response response) {
  }
}
