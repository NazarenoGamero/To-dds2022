package dds.grupo3.api.service.impl;

import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.service.FactorEmisionService;
import dds.grupo3.clases.medible.FactorEmision;
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
}
