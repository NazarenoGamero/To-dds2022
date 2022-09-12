package dds.grupo3.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.repository.RepoSector;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
	@Autowired
	RepoOrganizacion repo;
	
	@Autowired
	RepoSector repoSector;
	
	@Override
	public List<Organizacion> buscarOrganizaciones() {
		return repo.findAll();
	}

	@Override
	public void crearOrganizacion(OrganizacionDTO org) {
		Organizacion nuevaOrg = new Organizacion(org);
		repo.save(nuevaOrg);
	}

	@Override
	public void borrarOrg(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void editarOrg(Long id, OrganizacionDTO org) {
		//Busco la Organizacion
		Optional<Organizacion> laOrg = repo.findById(id);
		//Si la DB pudo conseguir algo, la modifico
		if(laOrg.isPresent()) {
			laOrg.get().setClasificacion(org.getClasificacion());
			laOrg.get().setRazonSocial(org.getRazonSocial());
			laOrg.get().setSectores(org.getSectores());
			laOrg.get().setTipo(org.getTipo());
		}
		repo.save(laOrg.get());
	}

	@Override
	public void agregarMiembro(Long id, MiembroDTO miembro){
		Optional<Organizacion> org = repo.findById(id);
		if(org.isPresent()) {
			Optional<Sector> sector = repoSector.findByNombreAndOrganizacionId(miembro.getSector(), org.get().getId());
			Miembro nuevoMiembro = new Miembro(miembro);
			org.get().agregarMiembroSector(sector.get(), nuevoMiembro);
		}
		
	}
	
	
}