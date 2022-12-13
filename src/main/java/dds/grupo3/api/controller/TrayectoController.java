package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/trayectos")
public interface TrayectoController {

	@GetMapping("/")
	public String principalTrayecto(Model model);
	
	@GetMapping("/miembro")
	public String trayectosMiembro(Model model,
			@RequestParam(value = "id_miembro", required = true) Long miembroId);
	
	@GetMapping("/error")
	public String error();
}
