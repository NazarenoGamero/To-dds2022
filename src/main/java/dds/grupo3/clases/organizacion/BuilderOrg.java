package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.clases.exception.NoSeEncontroClasifException;
import dds.grupo3.clases.exception.NoSeEncontroTipoException;

public class BuilderOrg {
  private List<TipoOrg> tiposOrg;
  private List<Clasificacion> clasificaciones;

  public Organizacion crearOrg() {
    return new Organizacion();//TODO especificar como y que se arma de una organizacion
  }


  public void Inicializar() {
    this.getTiposOrg().add(new TipoOrg("Gubernamental"));
    this.getTiposOrg().add(new TipoOrg("ONG"));
    this.getTiposOrg().add(new TipoOrg("Empresa"));
    this.getTiposOrg().add(new TipoOrg("Institucion"));
    this.getClasificaciones().add(new Clasificacion("Ministerio"));
    this.getClasificaciones().add(new Clasificacion("Universidad"));
    this.getClasificaciones().add(new Clasificacion("Escuela"));
    this.getClasificaciones().add(new Clasificacion("Empresa del sector primario"));
    this.getClasificaciones().add(new Clasificacion("Empresa del sector secundario"));
  }

  public BuilderOrg() {
    this.tiposOrg = new ArrayList<TipoOrg>();
    this.clasificaciones = new ArrayList<Clasificacion>();
  }


  public List<TipoOrg> getTiposOrg() {
    return tiposOrg;
  }


  public void setTiposOrg(List<TipoOrg> tiposOrg) {
    this.tiposOrg = tiposOrg;
  }


  public List<Clasificacion> getClasificaciones() {
    return clasificaciones;
  }


  public void setClasificaciones(List<Clasificacion> clasificaciones) {
    this.clasificaciones = clasificaciones;
  }

  public TipoOrg buscarTipo(String tipo) throws NoSeEncontroTipoException {
    for (TipoOrg unTipo : this.getTiposOrg()) {
      if (unTipo.getTipo().equals(tipo)) {
        return unTipo;
      }
    }
    throw new NoSeEncontroTipoException();
  }

  public Clasificacion buscarClasificacion(String clasif) throws NoSeEncontroClasifException {
    for (Clasificacion unaClasi : this.getClasificaciones()) {
      if (unaClasi.getNombre().equals(clasif)) {
        return unaClasi;
      }
    }
    throw new NoSeEncontroClasifException();
  }
}
