package dds.grupo3.clases.repositorios;

import com.sun.org.apache.xpath.internal.operations.Or;
import dds.grupo3.clases.organizacion.Organizacion;

import java.util.*;
import java.util.stream.Collectors;

public class RepoOrganizaciones {
  //Muy posiblemente todos los repos sean Singleton
  private List<Organizacion> organizaciones;

  public RepoOrganizaciones() {
    organizaciones = new ArrayList<Organizacion>();
  }

  public List<Organizacion> getOrganizaciones() {
    return this.organizaciones;
  }

  public void agregar(Organizacion organizacion) {
    OptionalLong max = this.organizaciones.stream().mapToLong(x -> x.getId()).max();
    Long nextid = (max.isPresent()) ? (max.getAsLong() + 1L) : 1;
    organizacion.setId(nextid);
    organizaciones.add(organizacion);
  }

  public Organizacion encontrarPorId(Long id) {
    Optional<Organizacion> first =
        this.organizaciones.stream().filter(x -> x.getId().equals(id)).findFirst();
    if (first.isPresent()) {
      return first.get();
    }
    return null;
  }

  public void eliminar(Organizacion organizacion) {
    this.organizaciones.removeIf(org -> org.equals(organizacion));
  }
}
