package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.clases.organizacion.Organizacion;

@RequestMapping("/organizaciones")
public interface OrganizacionController {

	//--------------------------------------
	//		Consultas de HU
	//--------------------------------------
	
	@GetMapping("/calculoHU")
	public String calculoHU(@ModelAttribute("organizacion")Organizacion org, Model model);
	
	@GetMapping("/calculoHU/categoria")
	public String huCategoria(@ModelAttribute("organizacion")Organizacion org, Model model);
	
	@GetMapping("/calculoHU/sector")
	public String huSector(Model model);
	
	@GetMapping("/calculoHU/fecha")
	public String huFecha(Model model);
	
	//--------------------------------------
	//		ABM Organizaciones
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
