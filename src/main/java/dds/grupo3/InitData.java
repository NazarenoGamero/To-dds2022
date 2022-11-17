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
import dds.grupo3.clases.medible.FactorEmision;

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
		this.crearFactores();
		
	}
	
	private void crearFactores() {
		repoFactores.save(new FactorEmision("Gas Natural",(float) 1.1));
		repoFactores.save(new FactorEmision("Diesel/Gasoil",(float) 1.4));
		repoFactores.save(new FactorEmision("Fuel Oil",(float) 1.5));
		repoFactores.save(new FactorEmision("Electricidad",(float) 2.1));
	}
}