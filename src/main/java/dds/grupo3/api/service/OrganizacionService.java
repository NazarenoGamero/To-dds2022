package dds.grupo3.api.service;

import java.util.List;

import org.springframework.ui.Model;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;

public interface OrganizacionService {

	//Metodos para llamadas REST
	List<Organizacion> buscarOrganizaciones();
	
	public void crearOrganizacion(OrganizacionDTO org);
	
	public void borrarOrg(Long id);
	
	public void editarOrg(Long id, OrganizacionDTO org);
	
	public void agregarMiembro(Long id, MiembroDTO miembro);

	public List<MedicionTemplateDTO> mediciones(Organizacion org);
	
	//Metodos para llamadas MVC
	
	public float calcularHuella(Long org);
	
	public String huCategoria(Long orgId,Model model);
}
