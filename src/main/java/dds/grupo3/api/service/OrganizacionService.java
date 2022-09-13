package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.clases.organizacion.Organizacion;

public interface OrganizacionService {

	List<Organizacion> buscarOrganizaciones();
	
	public void crearOrganizacion(OrganizacionDTO org);
	
	public void borrarOrg(Long id);
	
	public void editarOrg(Long id, OrganizacionDTO org);
	
	public void agregarMiembro(Long id, MiembroDTO miembro);
}
