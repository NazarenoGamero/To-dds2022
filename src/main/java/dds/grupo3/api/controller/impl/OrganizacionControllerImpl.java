package dds.grupo3.api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dds.grupo3.api.controller.OrganizacionController;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.organizacion.Organizacion;

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
			return new ResponseEntity<>("sos un puto", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> crearOrganizacion(Organizacion org) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> borrarOrganizacion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> editarOrganizacion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
