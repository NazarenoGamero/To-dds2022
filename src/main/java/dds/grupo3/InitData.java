package dds.grupo3;

import java.util.HashSet;
import java.util.List;

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
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.trayectos.Punto;
import dds.grupo3.clases.trayectos.Tramo;
import dds.grupo3.clases.trayectos.Trayecto;
import dds.grupo3.clases.trayectos.transporte.Fisico;

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
		this.crearMiembroConTrayecto();
		
	}
	
	private void crearFactores() {
		repoFactores.save(new FactorEmision("Gas Natural",(float) 1.1));
		repoFactores.save(new FactorEmision("Diesel/Gasoil",(float) 1.4));
		repoFactores.save(new FactorEmision("Fuel Oil",(float) 1.5));
		repoFactores.save(new FactorEmision("Electricidad",(float) 2.1));
	}
	
	private void crearMiembroConTrayecto() {
		Miembro unMiembro = new Miembro("Mauro", "Rossi", TipoDocEnum.DNI, 41835967L);
		//Medio de transporte
		Fisico aPatin = new Fisico();
		aPatin.setConsumo(repoFactores.findById(1L).get());
		aPatin.setNombreTransporte("Pie");
		//Punto de inicio
		Punto inicio = new Punto();
		inicio.setAltura(360L);
		inicio.setCalle("Hortiguera");
		inicio.setLocalidadId(43L);
		//Punto de fin
		Punto fin = new Punto();
		fin.setAltura(500L);
		fin.setCalle("Hortiguera");
		fin.setLocalidadId(43L);
		//Tramo que los une
		Tramo unTramo = new Tramo();
		unTramo.setDistancia(140L);
		HashSet<Miembro> listaMiembros = new HashSet<Miembro>(); listaMiembros.add(unMiembro);
		unTramo.setMiembros(listaMiembros);
		unTramo.setPuntoDeLlegada(fin);
		unTramo.setPuntoInicio(inicio);
		unTramo.setTransporte(aPatin);
		//Creo el trayecto y lo asigno al miembro
		Trayecto nuevoTrayecto = new Trayecto();
		nuevoTrayecto.setTramos(List.of(unTramo));
		unMiembro.setTrayectos(List.of(nuevoTrayecto));
		repoMiembros.save(unMiembro);
	}
}