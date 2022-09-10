package dds.grupo3.api.repository;

import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoMiembro extends JpaRepository<Miembro, Long> {
	Optional<Miembro> findById(Long id);
	
	Optional<Organizacion> findByIdAndRazonSocial(Long id, String RazonSocial);
}
