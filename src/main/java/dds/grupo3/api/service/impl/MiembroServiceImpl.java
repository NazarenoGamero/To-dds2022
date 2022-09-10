package dds.grupo3.api.service.impl;

import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.organizacion.Organizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroServiceImpl implements OrganizacionService {

	@Autowired
	RepoOrganizacion repo;
	
	@Override
	public List<Organizacion> buscarOrganizaciones() {
		return repo.findAll();
	}

}
