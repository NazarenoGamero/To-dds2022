package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.service.FactorEmisionService;
import dds.grupo3.clases.medible.FactorEmision;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactorEmisionServiceImpl implements FactorEmisionService {

    @Autowired
    RepoFactorEmision repo;

    @Override
    public List<FactorEmision> buscarFactoresDeEmision() {
        return repo.findAll();
    }
    public void modificarValor(Long id, FactorEmisionDTO fe){
        Optional<FactorEmision> factor= repo.findById(id);
        if(factor.isPresent()) {
            factor.get().setValor(fe.getValor());
        }
        repo.save(factor.get());
    }
}
