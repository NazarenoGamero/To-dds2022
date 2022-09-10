package server;

import dds.grupo3.clases.notificaciones.MailSender;
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

//  public static void conectarDB(String[] args) {
//    Map<String, String> options = new HashMap<String, String>();
//    options.put("url","jdbc:mysql://<DBURL>:<PORT>/<Database>?user=<UserName>&password=<Password>");
//    options.put("dbtable", "<TableName>");
//    JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("DBConnection").setMaster("local[*]"));
//    SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
//    // DataFrame jdbcDF = sqlContext.load("jdbc", options).cache();
//    DataFrame jdbcDF = sqlContext.jdbc(options.get("url"),options.get("dbtable"));
//    System.out.println("Data------------------->" + jdbcDF.toJSON().first());
//    Row[] rows = jdbcDF.collect();
//    System.out.println("Without Filter \n ------------------------------------------------- ");
//    for (Row row2 : rows) {
//      System.out.println(row2.toString());
//    }
//    System.out.println("Filter Data\n ------------------------------------------------- ");
//    jdbcDF = jdbcDF.select("agency_id","route_id").where(jdbcDF.col("route_id").$less$eq(3));
//    rows = jdbcDF.collect();
//    for (Row row2 : rows) {
//      System.out.println(row2.toString());
//    }
//  }
}
