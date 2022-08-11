package dds.grupo3.clases.repositorios;

import com.sun.org.apache.xpath.internal.operations.Or;
import dds.grupo3.clases.organizacion.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class RepoOrganizaciones {
  //Muy posiblemente todos los repos sean Singleton
  private List<Organizacion> organizaciones;

  public RepoOrganizaciones(){new ArrayList<Organizacion>();}

  public List<Organizacion> getOrganizaciones(){return this.organizaciones;}

  public void agregar(Organizacion organizacion){
    organizaciones.add(organizacion);
  }

}
