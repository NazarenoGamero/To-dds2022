package dds.grupo3.api.controller;

import dds.grupo3.api.dto.request.AgenteSectorialDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/agentesSectoriales")
public interface AgenteSectorialController {
    @GetMapping("")
    public ResponseEntity<?> obtenerListaAgentesSectoriales();

    @PostMapping("")
    public ResponseEntity<?> crearAgenteSectorial(@RequestBody AgenteSectorialDTO ags);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAgenteSectorial(@PathVariable("id")Long id);

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAgenteSectorial(@PathVariable("id")Long id, @RequestBody AgenteSectorialDTO ags);
}
