package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.repository.RepoBatch;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.service.MedicionService;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicionServiceImpl implements MedicionService {
  @Autowired
  RepoMediciones repoMediciones;
  @Autowired
  RepoBatch repoBatch;

  @Override
  public List<Medible> buscarMediciones() {
    return repoMediciones.findAll();
  }

  @Override
  public void cargarMediciones(List<MedicionDTO> mediciones) {
    BatchMediciones batchMediciones= new BatchMediciones();
    Long id= repoBatch.save(batchMediciones).getId();
    mediciones.stream().forEach(m-> m.setBatch(id));
    mediciones.stream().forEach(m-> repoMediciones.save(new Medible(m)));
  }

  @Override
  public void borrarMedicion(Long id) {

  }
}
