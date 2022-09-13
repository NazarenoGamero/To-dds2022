package dds.grupo3.api.service;


import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;
import java.util.List;

public interface MedicionService {
  List<Medible> buscarMediciones();

  void cargarMediciones(List<MedicionDTO> mediciones);

  void borrarMedicion(Long id);
}
