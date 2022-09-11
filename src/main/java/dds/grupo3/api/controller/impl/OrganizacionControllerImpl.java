package dds.grupo3.api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dds.grupo3.api.controller.OrganizacionController;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;
import dds.grupo3.api.service.OrganizacionService;

@RestController
public class OrganizacionControllerImpl implements OrganizacionController {
	@Autowired
	OrganizacionService organizacionService;


	@Override
	public ResponseEntity<?> obtenerListaOrganizaciones() {
		ListaOrganizacionesDTO response = new ListaOrganizacionesDTO();
		//traigo de la DB
		//Ojo con hacer mucha logica aca
		//Aca solo llamas services
		try {
			response.setOrganizaciones(organizacionService.buscarOrganizaciones());
		} catch (Exception e){
			return new ResponseEntity<>("Hubo un error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> crearOrganizacion(OrganizacionDTO org) {
		organizacionService.crearOrganizacion(org);
		return new ResponseEntity<>("Se creo la organizacion correctamente", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> borrarOrganizacion(Long id) {
		organizacionService.borrarOrg(id);
		return new ResponseEntity<>("Se borro la organizacion correctamente", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editarOrganizacion(Long id, OrganizacionDTO org) {
		organizacionService.editarOrg(id,org);
		return new ResponseEntity<>("Se modifico la organizacion exitosamente", HttpStatus.OK);
	}
}