package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrganizacionController {

	@GetMapping("")
	public ResponseEntity<?> obtenerListaOrganizaciones();
	
}
