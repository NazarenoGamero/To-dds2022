package dds.grupo3.clases.repositorios;

import dds.grupo3.clases.medible.FactorEmision;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class RepoFactoresDeEmision {
  private List<FactorEmision> fe;
  private static RepoFactoresDeEmision instance=null;

  public static RepoFactoresDeEmision getInstance() {
    if(instance==null)
      instance = new RepoFactoresDeEmision();
    return instance;
  }

  private RepoFactoresDeEmision() {
    fe = new ArrayList<FactorEmision>();
  }

  public List<FactorEmision> getFe() {
    return this.fe;
  }

  public void agregar(FactorEmision miembro) {
    OptionalLong max = this.fe.stream().mapToLong(x -> x.getId()).max();
    Long nextid = (max.isPresent()) ? (max.getAsLong() + 1L) : 1;
    miembro.setId(nextid);
    fe.add(miembro);
  }

  public FactorEmision encontrarPorId(Long id) {
    Optional<FactorEmision> first =
        this.fe.stream().filter(x -> x.getId().equals(id)).findFirst();
    if (first.isPresent()) {
      return first.get();
    }
    return null;
  }

  public void eliminar(FactorEmision miembro) {
    this.fe.removeIf(org -> org.equals(miembro));
  }

  public void eliminarPorId(Long id) {
    this.fe.removeIf(x->x.getId().equals(id));
  }
}
