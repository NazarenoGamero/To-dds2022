package server;

import com.google.gson.Gson;
import dds.grupo3.clases.repositorios.RepoOrganizaciones;
import server.controllers.OrganizacionController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
  private static HandlebarsTemplateEngine engine;

  private static void initEngine() {
    Router.engine = HandlebarsTemplateEngineBuilder
        .create()
        .withDefaultHelpers()
        .withHelper("isTrue", BooleanHelper.isTrue)
        .build();
  }

  public static void init() {
    Router.initEngine();
    Spark.staticFileLocation("/public");
    Router.configure();
  }

  public static void configure() {
    Gson gson = new Gson();
    RepoOrganizaciones repoOrganizaciones =
        new RepoOrganizaciones();
    //Esto deberia estar dentro del constructor de OrganizacionController
    OrganizacionController organizacionController = new OrganizacionController(repoOrganizaciones);

    Spark.path("/api", () -> {
      //CRUD de Organizaciones
      Spark.path("/organizations", () -> {
        Spark.get("", organizacionController::list, gson::toJson);
        Spark.get("/:id", organizacionController::get, gson::toJson);
        Spark.post("", organizacionController::add, gson::toJson);
        // Spark.put("/",     organizacionController::change,gson::toJson);   //TODO
        Spark.delete("/:id", organizacionController::delete);
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
}
