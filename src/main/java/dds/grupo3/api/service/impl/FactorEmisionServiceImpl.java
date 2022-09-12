package dds.grupo3.api.service.impl;

import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.clases.organizacion.Organizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactorEmisionServiceImpl {

    @Autowired
    RepoFactorEmision repo;

    @Override
    public List<Organizacion> buscarFactoresDeEmision() {
        return repo.findById();
    }
}
