package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factoresDeEmision")
public interface FactorEmisionController {
    @PutMapping("/{id}")
    public ResponseEntity<?> editarFactoresDeEmisionController(@PathVariable("id")Integer id);
}