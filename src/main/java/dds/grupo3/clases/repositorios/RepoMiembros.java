package dds.grupo3.clases.repositorios;

import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class RepoMiembros {
  private List<Miembro> miembros;

  public RepoMiembros() {
    miembros = new ArrayList<Miembro>();
  }

  public List<Miembro> getMiembros() {
    return this.miembros;
  }

  public void agregar(Miembro miembro) {
    OptionalLong max = this.miembros.stream().mapToLong(x -> x.getId()).max();
    Long nextid = (max.isPresent()) ? (max.getAsLong() + 1L) : 1;
    miembro.setId(nextid);
    miembros.add(miembro);
  }

  public Miembro encontrarPorId(Long id) {
    Optional<Miembro> first =
        this.miembros.stream().filter(x -> x.getId().equals(id)).findFirst();
    if (first.isPresent()) {
      return first.get();
    }
    return null;
  }

  public void eliminar(Miembro miembro) {
    this.miembros.removeIf(org -> org.equals(miembro));
  }

  public void eliminarPorId(Long id) {
    this.miembros.removeIf(x->x.getId().equals(id));
  }
}
