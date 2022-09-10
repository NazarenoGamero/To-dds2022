package dds.grupo3.api.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dds.grupo3.api.controller.OrganizacionController;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;

public class OrganizacionControllerImpl implements OrganizacionController {

	@Override
	public ResponseEntity<?> obtenerListaOrganizaciones() {
		ListaOrganizacionesDTO response = null;
		//traigo de la DB
		return new ResponseEntity(response, HttpStatus.OK);
	}

}
