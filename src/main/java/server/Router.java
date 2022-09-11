package server;

import com.google.gson.Gson;
import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.repositorios.RepoFactoresDeEmision;
import dds.grupo3.clases.repositorios.RepoMediciones;
import dds.grupo3.clases.repositorios.RepoMiembros;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import server.controllers.FactoresDeEmisionController;
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
    RepoOrganizaciones repoOrganizaciones = RepoOrganizaciones.getInstance();
    RepoMiembros repoMiembros= RepoMiembros.getInstance();
    RepoMediciones repoMediciones= RepoMediciones.getInstance();
    RepoFactoresDeEmision repoFactoresDeEmision= RepoFactoresDeEmision.getInstance();
    OrganizacionController organizacionController = new OrganizacionController(repoOrganizaciones, repoMiembros);
    cargarMiembros(repoMiembros);
    FactoresDeEmisionController factoresDeEmisionController= new FactoresDeEmisionController(repoFactoresDeEmision);
    cargarFactoresDeEmision(repoFactoresDeEmision);
    Spark.get("/", (request, response) -> {
      return "Hello";
    });
    Spark.path("/api", () -> {
      Spark.get("/miembros", (request, response)->{return repoMiembros.getMiembros();},gson::toJson);
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
      //Modificacion Mediciones
      Spark.path("/factores", () -> {
        Spark.get("",(request,response)->{response.type("application/json");
                                                  return repoFactoresDeEmision.getFe();},gson::toJson);
        Spark.put("/:id", factoresDeEmisionController::modificar);
      });

      //Listado y Filtros de Mediciones
      Spark.get("/mediciones",medicionesController::list,gson.toJson());
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
  private void cargarFactoresDeEmision(RepoFactoresDeEmision repo) {
    FactorEmision f1= new FactorEmision("energia-electrica", 7.5F);
    FactorEmision f2= new FactorEmision("combustibles-fosiles",1.2F);
    repo.agregar(f1);
    repo.agregar(f2);
  }

}
