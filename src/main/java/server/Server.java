package server;

import dds.grupo3.clases.notificaciones.MailSender;
import javax.mail.MessagingException;
import spark.Spark;
//import spark.debug.DebugScreen;

public class Server {
  public static void main(String[] args) {
    Router router= new Router();
    Spark.port(getHerokuAssignedPort());
    MailSender.sendMail("mopup2017@gmail.com", "¡Su huella de carbono es mas de 9000!");
    router.init();
    //DebugScreen.enableDebugScreen();
  }

  private static int getHerokuAssignedPort() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 7000;
  }
}
