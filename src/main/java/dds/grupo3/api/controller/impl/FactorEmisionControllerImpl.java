package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.FactorEmisionController;
import dds.grupo3.api.dto.request.FactorEmisionDTO;
import dds.grupo3.api.service.FactorEmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorEmisionControllerImpl implements FactorEmisionController {
    @Autowired
    FactorEmisionService factorEmisionService;

    @Override
    public ResponseEntity<?> editarFactoresDeEmision(Long id, FactorEmisionDTO fe) {
        factorEmisionService.modificarValor(id,fe);
        return new ResponseEntity<>("Se modificó el factor de emisión correctamente", HttpStatus.OK);
    }
}