package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;

public interface BatchService {
	
  void borrarBatch(Long id);
  
  BatchDTO buscarMediciones(Long id);
  
  void cargarBatch(List<MedicionDTO> mediciones);
  
  void asignarBatch(Long id, Long idOrg);
}
