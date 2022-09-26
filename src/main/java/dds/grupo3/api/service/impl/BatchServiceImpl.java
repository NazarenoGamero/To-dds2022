package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;
import dds.grupo3.api.repository.RepoBatch;
import dds.grupo3.api.service.BatchService;
import dds.grupo3.api.service.MedicionService;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {
  @Autowired
  RepoBatch repo;

  @Override
  public void borrarBatch(Long id) {
    repo.deleteById(id);
  }

  @Override
  public BatchDTO buscarMediciones(Long id) {
    Optional<BatchMediciones> batch= repo.findById(id);
    if(!batch.isPresent())
      throw new RuntimeException("No existe el batch");

    return new BatchDTO(batch.get());
  }

  @Override
  public void cargarBatch(List<MedicionDTO> mediciones) {
    BatchMediciones batchMediciones= new BatchMediciones();
    for(MedicionDTO m :mediciones){
      Medible medible = new Medible(m);
      medible.setBatch(batchMediciones);
      batchMediciones.getMediciones().add(medible);
    }
    repo.save(batchMediciones);
  }
}
