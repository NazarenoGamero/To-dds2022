package dds.grupo3.api.controller;

import dds.grupo3.api.dto.request.MedicionDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mediciones")
public interface MedicionController {

  @GetMapping("")
  public ResponseEntity<?> obtenerListaDeMediciones();

  @PostMapping("")
  public ResponseEntity<?> cargarMediciones(@RequestBody List<MedicionDTO> mediciones);

  @DeleteMapping("/{id}")
  public ResponseEntity<?> borrarMedicion(@PathVariable("id")Long id);

}
