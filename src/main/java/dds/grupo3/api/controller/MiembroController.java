package dds.grupo3.api.controller;


import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miembros")
public interface MiembroController {

	@GetMapping("")
	public ResponseEntity<?> obtenerListaMiembros();
	
	@PostMapping("")
	public ResponseEntity<?> crearMiembro(@RequestBody Miembro org);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarMiembro(@PathVariable("id")Integer id);
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarMiembro(@PathVariable("id")Integer id);
	
}
