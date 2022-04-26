package dds.grupo3.clases;

import java.util.Collection;
import java.util.Map;

public interface FachadaOrg {

    void cargarParametros(Map<String, Float> parametrosSistema);

    Float obtenerHU(Collection<Medible> mediciones);
}