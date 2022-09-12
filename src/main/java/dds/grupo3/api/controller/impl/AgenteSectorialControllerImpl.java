package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.AgenteSectorialController;
import dds.grupo3.api.dto.request.AgenteSectorialDTO;
import dds.grupo3.api.dto.response.ListaAgentesSectorialesDTO;
import dds.grupo3.api.service.AgenteSectorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgenteSectorialControllerImpl implements AgenteSectorialController {
    @Autowired
    AgenteSectorialService agenteSectorialService;

    @Override
    public ResponseEntity<?> obtenerListaAgentesSectoriales() {
        ListaAgentesSectorialesDTO response = new ListaAgentesSectorialesDTO();
        //traigo de la DB
        //Ojo con hacer mucha logica aca
        //Aca solo llamas services
        try {
            response.setAgentesSectoriales(agenteSectorialService.buscarAgentesSctoriales());
        } catch (Exception e){
            return new ResponseEntity<>("Hubo un error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearAgenteSectorial(AgenteSectorialDTO ags) {
        agenteSectorialService.crearAgenteSectorial(ags);
        return new ResponseEntity<>("Se creo la organizacion correctamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarAgenteSectorial(Long id) {
        agenteSectorialService.borrarAgenteSectorial(id);
        return new ResponseEntity<>("Se borro la organizacion correctamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> editarAgenteSectorial(Long id, AgenteSectorialDTO ags) {
        agenteSectorialService.editarAgenteSectorial(id, ags);
        return new ResponseEntity<>("Se modifico la organizacion exitosamente", HttpStatus.OK);
    }
}
