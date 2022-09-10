package dds.grupo3.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.organizacion.Organizacion;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
	@Autowired
	RepoOrganizacion repo;
	
	@Override
	public List<Organizacion> buscarOrganizaciones() {
		return repo.findAll();
	}
}