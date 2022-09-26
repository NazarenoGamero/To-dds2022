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

@RequestMapping("/batchMediciones")
public interface BatchController {

  @GetMapping("/{id}")
   ResponseEntity<?> consultarBatch(@PathVariable("id")Long id);
  @PostMapping("")
   ResponseEntity<?> cargarBatch(@RequestBody List<MedicionDTO> mediciones);
  @DeleteMapping("/{id}")
   ResponseEntity<?> borrarBatch(@PathVariable("id")Long id);

}
