package dds.grupo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dds.grupo3.api.repository.RepoAgenteSectorial;
import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.repository.RepoSector;

@Component
public class InitData implements CommandLineRunner {
	//Agrego todos los repos por si quiero inicializar algo
	@Autowired
	RepoAgenteSectorial repoAgentes;
	@Autowired
	RepoFactorEmision repoFactores;
	@Autowired
	RepoMediciones repoMediciones;
	@Autowired
	RepoMiembro repoMiembros;
	@Autowired
	RepoOrganizacion repoOrg;
	@Autowired
	RepoSector repoSectores;
	
	@Override
	public void run(String... args) throws Exception {
		//TODO aca va todo lo que se quiere inicializar en la base
		
	}
}