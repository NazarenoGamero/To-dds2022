package dds.grupo3.api.repository;

import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBatch extends JpaRepository<BatchMediciones, Long> {
  Optional<BatchMediciones> findById(Long id);
}
