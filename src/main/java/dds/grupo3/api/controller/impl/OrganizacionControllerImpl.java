package dds.grupo3.api.controller.impl;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.clases.medible.Medible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import dds.grupo3.api.controller.OrganizacionController;
import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;
import dds.grupo3.api.service.OrganizacionService;

import java.util.List;

@Controller
public class OrganizacionControllerImpl implements OrganizacionController {
	@Autowired
	OrganizacionService organizacionService;


	@Override
	public String obtenerListaOrganizaciones() {
		ListaOrganizacionesDTO response = new ListaOrganizacionesDTO();
		//traigo de la DB
		//Ojo con hacer mucha logica aca
		//Aca solo llamas services
		try {
			response.setOrganizaciones(organizacionService.buscarOrganizaciones());
		} catch (Exception e){
			return "error";
		}
		return "Ok";
	}

	@Override
	public String crearOrganizacion(OrganizacionDTO org) {
		organizacionService.crearOrganizacion(org);
		return "ok";
	}

	@Override
	public String borrarOrganizacion(Long id) {
		organizacionService.borrarOrg(id);
		return "ok";
	}

	@Override
	public String editarOrganizacion(Long id, OrganizacionDTO org) {
		organizacionService.editarOrg(id,org);
		return "ok";
	}

	@Override
	public String agregarMiembro(Long id, MiembroDTO miembro) {
		try {
			organizacionService.agregarMiembro(id,miembro);
		} catch(Exception e) {
			return "error";
		}
		
		return "ok";
	}
	
	//TODO seguir este ejemplo. El archivo template se llama "prueba" y por eso se completa ahi la informacion
	public String prueba(Model model) {
		model.addAttribute("algo", "asd");
		return "prueba";
		
	}
	
	/*
	 * Obtengo la pagina de calculoHU principal para elegir la organizacion
	 */
	public String calculoHU(Model model) {
		//model.addAttribute("organizacions", organizacionService.buscarOrganizaciones().stream().map(org -> (org.getRazonSocial())).collect(Collectors.toList()));
		model.addAttribute("organizacions", organizacionService.buscarOrganizaciones());
		return "calcularHU";
	}

	/*
	 * A partir de la pantalla donde el usuario eligió la organizacion. Obtengo la huella de esa organizacion
	 */
	@Override
	public String huValor(Long orgId,Model model) {
		float total= organizacionService.calcularHuella(orgId);
		model.addAttribute("organizacions", organizacionService.buscarOrganizaciones());
		model.addAttribute("valorHU", total);
		return "calcularHUvalorHU";//TODO hacer que este metodo reciba informacion del modelo anterior
	}

	@Override
	public String huCategoria(Long orgId,Model model) {
		List<MedicionTemplateDTO> mediciones = organizacionService.mediciones(orgId);
		model.addAttribute("HUs", mediciones);
		return "calcularHUdesgloseCategoria";
	}

	@Override
	public String huSector(Long orgId, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String huFecha(Long orgId,Model model) {
		// TODO Auto-generated method stub
		return null;
	}
}