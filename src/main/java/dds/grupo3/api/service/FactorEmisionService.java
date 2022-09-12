package dds.grupo3.api.service;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.organizacion.Organizacion;

import java.util.List;

public interface FactorEmisionService {
    List<FactorEmision> buscarFactoresDeEmision();
}
