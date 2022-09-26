package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.BatchController;
import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;
import dds.grupo3.api.service.BatchService;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchControllerImpl implements BatchController {

  @Autowired
  BatchService batchService;

  @Override
  public ResponseEntity<?> consultarBatch(Long id) {
    try{
      BatchDTO batch = batchService.buscarMediciones(id);
      return new ResponseEntity<>(batch,HttpStatus.OK);
    }
   catch (RuntimeException e){
      return new ResponseEntity<>("El Batch no existe",HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseEntity<?> cargarBatch(List<MedicionDTO> mediciones) {
    try{
      batchService.cargarBatch(mediciones);
      return new ResponseEntity<>("El Batch de mediciones se cargo correctamente",HttpStatus.CREATED);
    }
    catch (RuntimeException e){
      return new ResponseEntity<>("No se pudo cargar el Batch",HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseEntity<?> borrarBatch(Long id) {
    try{
      batchService.borrarBatch(id);
      return new ResponseEntity<>("El Batch de mediciones "+id.toString()+ " se borró correctamente", HttpStatus.OK);
    }
    catch (RuntimeException e){
      return new ResponseEntity<>("El Batch no existe",HttpStatus.BAD_REQUEST);
    }
  }
}
