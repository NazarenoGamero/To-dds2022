package dds.grupo3.api.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import dds.grupo3.api.controller.TrayectoController;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.service.TrayectoService;
import dds.grupo3.clases.miembro.Miembro;

@Controller
public class TrayectoControllerImpl implements TrayectoController {

	@Autowired
	RepoMiembro repoMiembros;
	
	@Autowired
	TrayectoService trayectoService;
	
	@Override
	public String principalTrayecto(Model model) {
		List<Miembro> miembros = repoMiembros.findAll();
		model.addAttribute("empleados", miembros);
		return "trayecto";
	}

	@Override
	public String trayectosMiembro(Model model, Long miembroId) {
//		List<TrayectoDTO> trayectos = trayectoService.buscarTrayectos(miembroId);
		return null;
	}

	@Override
	public String error() {
		return "error";
	}

}
