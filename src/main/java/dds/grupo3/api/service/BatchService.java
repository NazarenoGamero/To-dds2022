package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.util.List;

public interface BatchService {
  void borrarBatch(Long id);
  BatchDTO buscarMediciones(Long id);
  void cargarBatch(List<MedicionDTO> mediciones);
}
