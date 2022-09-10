package server;

import com.google.gson.Gson;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.repositorios.RepoMiembros;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import server.controllers.OrganizacionController;
import spark.Spark;
/*
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;
*/
public class Router {
  //private static HandlebarsTemplateEngine engine;
  /*private static void initEngine() {
    Router.engine = HandlebarsTemplateEngineBuilder
        .create()
        .withDefaultHelpers()
        .withHelper("isTrue", BooleanHelper.isTrue)
        .build();
  }
   */

  public void init() {
    //Router.initEngine();
    Spark.staticFileLocation("/public");
    configure();
  }

  public void configure() {
    Gson gson = new Gson();
    RepoOrganizaciones repoOrganizaciones = new RepoOrganizaciones();
    RepoMiembros repoMiembros= new RepoMiembros();
    OrganizacionController organizacionController = new OrganizacionController(repoOrganizaciones, repoMiembros);
    cargarMiembros(repoMiembros);

    Spark.get("/", (request, response) -> {
      return "Hello";
    });
    Spark.path("/api", () -> {
      //CRUD de Organizaciones
      Spark.path("/organizations", () -> {
        Spark.get("", organizacionController::list, gson::toJson);
        Spark.get("/:id", organizacionController::get, gson::toJson);
        Spark.post("", organizacionController::add, gson::toJson);
        Spark.put("/:id",     organizacionController::change,gson::toJson);
        Spark.delete("/:id", organizacionController::delete);
        Spark.post("/:id/miembros",organizacionController::assignMember);
      });
      //CRUD Agente Social
      Spark.path("/social-agents", () -> {
                /*
                Spark.get("/",       AgenteSocialController::get,gson::toJson);
                Spark.post("/",       AgenteSocialController::add,gson::toJson);
                Spark.put("/",     AgenteSocialController::change,gson::toJson);
                Spark.delete("/",  AgenteSocialController::delete)
                 */
      });
    });
  }

  private void cargarMiembros(RepoMiembros repo) {
    Miembro m1= new Miembro("Juan","Lopez", TipoDocEnum.DNI,Long.parseLong("111111"));
    Miembro m2= new Miembro("Lucas","Perez", TipoDocEnum.DNI,Long.parseLong("565454"));
    Miembro m3= new Miembro("Pedro","Rodriguez", TipoDocEnum.DNI,Long.parseLong("22222"));
    Miembro m4= new Miembro("Alberto","Fernandez", TipoDocEnum.LC,Long.parseLong("14545454"));
    Miembro m5= new Miembro("Rodrigo","Diaz", TipoDocEnum.DNI,Long.parseLong("1154511"));
    Miembro m6= new Miembro("Juan","Hernandez", TipoDocEnum.LE,Long.parseLong("872444"));
    repo.agregar(m1);
    repo.agregar(m2);
    repo.agregar(m3);
    repo.agregar(m4);
    repo.agregar(m5);
    repo.agregar(m6);
  }
}
