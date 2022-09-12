package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.FactorEmisionController;
import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.api.service.FactorEmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class FactorEmisionControllerImpl implements FactorEmisionController {
    @Autowired
    FactorEmisionService factorEmisionService;

    @Override
    public ResponseEntity<?> editarFactoresDeEmision(Integer id, FactorEmisionDTO fe) {
        // TODO Auto-generated method stub
        return null;
    }
}