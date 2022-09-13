package dds.grupo3.api.repository;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoMediciones extends JpaRepository<Medible, Long> {
  Optional<Medible> findById(Long id);
}
