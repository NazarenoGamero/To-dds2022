package dds.grupo3.clases.repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;

public class RepoMediciones {
	private List<Medible> mediciones;
	 
	public RepoMediciones() {
	    mediciones = new ArrayList<Medible>();
	  }

	  public List<Medible> getOrganizaciones() {
	    return this.mediciones;
	  }

	  public void agregar(Medible medicion) {
	    OptionalLong max = this.mediciones.stream().mapToLong(x -> x.getId()).max();
	    Long nextid = (max.isPresent()) ? (max.getAsLong() + 1L) : 1;
	    medicion.setId(nextid);
	    this.mediciones.add(medicion);
	  }

	  public Medible encontrarPorId(Long id) {
	    Optional<Medible> first = this.mediciones.stream().filter(x -> x.getId() == id).findFirst();
	    if (first.isPresent()) {
	      return first.get();
	    }
	    return null;
	  }
}
