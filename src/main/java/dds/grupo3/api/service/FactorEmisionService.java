package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.clases.medible.FactorEmision;

import java.util.List;

public interface FactorEmisionService {
    List<FactorEmision> buscarFactoresDeEmision();
    void modificarValor(Long id, FactorEmisionDTO fe);

}
