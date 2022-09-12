package dds.grupo3.api.repository;

import dds.grupo3.clases.medible.FactorEmision;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RepoFactorEmision extends JpaRepository<FactorEmision, Long> {
    Optional<FactorEmision> findById(Long id);
}