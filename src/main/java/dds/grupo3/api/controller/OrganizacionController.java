package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;

@RequestMapping("/organizaciones")
public interface OrganizacionController {

	@GetMapping("/prueba")
	public String prueba(Model model);
	
	@GetMapping("")
	public ResponseEntity<?> obtenerListaOrganizaciones();
	
	@PostMapping("")
	public ResponseEntity<?> crearOrganizacion(@RequestBody OrganizacionDTO org);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarOrganizacion(@PathVariable("id")Long id);
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarOrganizacion(@PathVariable("id")Long id, @RequestBody OrganizacionDTO org);

	@PostMapping("/{id}")
	public ResponseEntity<?> agregarMiembro(@PathVariable("id")Long id,@RequestBody MiembroDTO miembro);
}
