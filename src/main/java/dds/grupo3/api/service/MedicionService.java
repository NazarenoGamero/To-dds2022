package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.clases.medible.Medible;
import java.util.List;

public interface MedicionService {
  List<MedicionDTO> buscarMediciones();
}
