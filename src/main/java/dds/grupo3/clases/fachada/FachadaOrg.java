package dds.grupo3.clases.fachada;

import dds.grupo3.clases.medible.Medible;
import java.util.Collection;
import java.util.Map;

public interface FachadaOrg {
  public void cargarParametros(Map<String, Float> parametrosSistema);
  public String obtenerHU(Collection<Medible> mediciones);
}
