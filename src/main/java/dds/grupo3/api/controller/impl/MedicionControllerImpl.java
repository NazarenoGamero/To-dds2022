package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.MedicionController;
import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;
import dds.grupo3.api.service.MedicionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicionControllerImpl implements MedicionController {
    @Autowired
    MedicionService medicionService;
    @Override
    public ResponseEntity<?> obtenerListaDeMediciones() {
      //List<MedicionDTO> response = new ListaOrganizacionesDTO();
      //traigo de la DB
      //Ojo con hacer mucha logica aca
      //Aca solo llamas services
      try {
       // response.setOrganizaciones(medicionService.buscarMediciones());
      } catch (Exception e){
        return new ResponseEntity<>("Hubo un error", HttpStatus.BAD_REQUEST);
      }
      return null; //new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> cargarMediciones(List<MedicionDTO> mediciones) {
      medicionService.cargarMediciones(mediciones);
      return new ResponseEntity<>("Se cargaron las mediciones correctamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarMedicion(Long id) {
      medicionService.borrarMedicion(id);
      return new ResponseEntity<>("Se borro la organizacion correctamente", HttpStatus.OK);
    }

}
