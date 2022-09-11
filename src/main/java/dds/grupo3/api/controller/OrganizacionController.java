package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.clases.organizacion.Organizacion;

@RequestMapping("/organizaciones")
public interface OrganizacionController {

	@GetMapping("")
	public ResponseEntity<?> obtenerListaOrganizaciones();
	
	@PostMapping("")
	public ResponseEntity<?> crearOrganizacion(@RequestBody Organizacion org);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarOrganizacion(@PathVariable("id")Integer id);
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarOrganizacion(@PathVariable("id")Integer id);
	
}
