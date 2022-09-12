package dds.grupo3.api.controller;

import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factoresDeEmision")
public interface FactorEmisionController {
    @PutMapping("/{id}")
    public ResponseEntity<?> editarFactoresDeEmision(@PathVariable("id")Long id, @RequestBody FactorEmisionDTO fe);
}