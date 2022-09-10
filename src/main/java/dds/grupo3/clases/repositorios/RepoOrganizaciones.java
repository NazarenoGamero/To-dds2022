package dds.grupo3.clases.repositorios;

import dds.grupo3.clases.organizacion.Organizacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class RepoOrganizaciones {

  private List<Organizacion> organizaciones;
  private static RepoOrganizaciones instance=null;

  private RepoOrganizaciones() {
    organizaciones = new ArrayList<Organizacion>();
  }

  public static RepoOrganizaciones getInstance() {
    if(instance==null)
      instance = new RepoOrganizaciones();
    return instance;
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

  public void eliminarPorId(Long id) {
    this.organizaciones.removeIf(x->x.getId().equals(id));
  }
}
