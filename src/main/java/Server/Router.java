package Server;

import Server.Controllers.AgenteSocialController;
import Server.Controllers.OrganizacionController;
import com.google.gson.Gson;
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

        Spark.path("/api", () -> {
            //CRUD de Organizaciones
            Spark.path("/organizations", () -> {
                Spark.get("/",       OrganizacionController::list,gson::toJson);
                Spark.post("/",       OrganizacionController::add,gson::toJson);
                Spark.put("/",     OrganizacionController::change,gson::toJson);
                Spark.delete("/",  OrganizacionController::delete);
            });
            //CRUD Agente Social
            Spark.path("/social-agents", () -> {
                Spark.get("/",       AgenteSocialController::get,gson::toJson);
                Spark.post("/",       AgenteSocialController::add,gson::toJson);
                Spark.put("/",     AgenteSocialController::change,gson::toJson);
                Spark.delete("/",  AgenteSocialController::delete);
            });
        });
    }
}

/*
RepoLibros repo = new RepoLibros();
    LibrosController controller = new LibrosController(repo);  //aca deberia instanciar todos mis controllers.
    Gson gson = new Gson();           //AGREGO gson para que convierta y devuelva los objetos en json

    Spark.get("/",(req,res)->"Hola");

    Spark.get("/libros",controller::list,gson::toJson);  //delego en cada controller la accion a realizar por cada request

    Spark.get("/libros/:id", controller::get,gson::toJson); //uso siempre el "::", nunca controller.unMetodo()

    Spark.delete("/libros/:id", controller::delete);  //el :id hace que se guarde como valor esa parte del path
                                                            //en este caso, guardar el id me servira para buscar el libro
    Spark.post("/libros/",controller::create,gson::toJson); //el gson se encarga de transformar lo que devuelva el
                                                                  //metodo a json
  }
 */