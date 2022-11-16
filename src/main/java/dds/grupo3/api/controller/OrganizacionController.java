package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;

@RequestMapping("/organizaciones")
public interface OrganizacionController {

	//--------------------------------------
	//		Consultas de HU (MVC)
	//--------------------------------------
	
	@GetMapping("/calculoHU")
	public String calculoHU(Model model);
	
	@GetMapping("/calculoHU/valor")
	public String huValor(@RequestParam(value = "org", required = false) Long orgId, Model model);
	
	@GetMapping("/calculoHU/categoria")
	public String huCategoria(@RequestParam(value = "org", required = false) Long orgId, Model model);
	
	@GetMapping("/calculoHU/sector")
	public String huSector(@RequestParam(value = "org", required = false) Long orgId,Model model);
	
	@GetMapping("/calculoHU/fecha")
	public String huFecha(@RequestParam(value = "org", required = false) Long orgId, Model model);
	
	//--------------------------------------
	//		ABM Organizaciones (REST)
	//--------------------------------------
	
	@GetMapping("")
	public String obtenerListaOrganizaciones();
	
	@PostMapping("")
	public String crearOrganizacion(@RequestBody OrganizacionDTO org);
	
	
	@DeleteMapping("/{id}")
	public String borrarOrganizacion(@PathVariable("id")Long id);
	
	@PutMapping("/{id}")
	public String editarOrganizacion(@PathVariable("id")Long id, @RequestBody OrganizacionDTO org);

	@PostMapping("/{id}")
	public String agregarMiembro(@PathVariable("id")Long id,@RequestBody MiembroDTO miembro);
}
