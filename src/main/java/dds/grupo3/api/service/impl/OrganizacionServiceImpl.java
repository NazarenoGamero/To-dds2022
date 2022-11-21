package dds.grupo3.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.AnioDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.repository.RepoSector;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
	@Autowired
	RepoOrganizacion repo;
	
	@Autowired
	RepoSector repoSector;
	
	@Autowired
	RepoMiembro repoMiembro;
	
	@Autowired
	RepoMediciones repoMed;
	
	@Override
	public Organizacion obtenerOrg(Long id) {
		return repo.findById(id).get();
	}
	
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
			repoMiembro.save(nuevoMiembro);
			org.get().agregarMiembroSector(sector.get(), nuevoMiembro);
			repoSector.save(sector.get());
		}
		
	}

	@Override
	public float calcularHuella(Long org) {
		return repo.findById(org).get().calcularHU();
	}
	
	@Override
	public List<MedicionTemplateDTO> mediciones(Long org) {
		Optional<Organizacion> laOrg = repo.findById(org);
		List<Medible> medicionesOrg = laOrg.get().getMediciones();
		List<MedicionTemplateDTO> medicionesTemplateDTO = new ArrayList<MedicionTemplateDTO>();
		for(Medible unMedible : medicionesOrg){
			MedicionTemplateDTO unMedibleDTO = new MedicionTemplateDTO();
			unMedibleDTO.setTipoDeActividad(unMedible.getTipoDeMedicion().getTipoDeactividad().getNombre());
			unMedibleDTO.setTipoDeConsumo(unMedible.getTipoDeMedicion().getTipoDeConsumo().getNombre());
			unMedibleDTO.setValor(unMedible.getValor());
			medicionesTemplateDTO.add(unMedibleDTO);
		}
		return medicionesTemplateDTO;
	}

	@Override
	public String huCategoria(Long orgId, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnioDTO> medicionesFecha(Long idOrg) {
		Organizacion org = repo.findById(idOrg).get();
		List<Medible> mediciones = org.getMediciones();
		
		return null;
	}
}