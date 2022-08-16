package dds.grupo3.clases.trayectos;

public class Parada extends Punto{
  private String nombreParada;

  private Punto paradaAnterior;

  private Punto paradaProxima;

  public Parada(float latitud, float longitud, String nombreParada, Punto paradaAnterior, Punto paradaProxima) {
    super(latitud, longitud);
    this.nombreParada = nombreParada;
    this.paradaAnterior = paradaAnterior;
    this.paradaProxima = paradaProxima;
  }

  public String getNombreParada() {
    return nombreParada;
  }

  public void setNombreParada(String nombreParada) {
    this.nombreParada = nombreParada;
  }

  public Punto getParadaAnterior() {
    return paradaAnterior;
  }

  public void setParadaAnterior(Punto paradaAnterior) {
    this.paradaAnterior = paradaAnterior;
  }

  public Punto getParadaProxima() {
    return paradaProxima;
  }

  public void setParadaProxima(Punto paradaProxima) {
    this.paradaProxima = paradaProxima;
  }
}