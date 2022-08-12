package dds.grupo3.clases.fachada;

import java.util.Collection;
import java.util.Map;

import dds.grupo3.clases.medible.Medible;

public interface FachadaOrg {

  void cargarParametros(Map<String, Float> parametrosSistema);

  Float obtenerHU(Collection<Medible> mediciones);
}