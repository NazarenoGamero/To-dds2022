package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mediciones")
public interface MedicionController {

  @GetMapping("")
   ResponseEntity<?> obtenerListaDeMediciones();

}
