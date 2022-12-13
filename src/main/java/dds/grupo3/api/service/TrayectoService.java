package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.clases.trayectos.Trayecto;

public interface TrayectoService {

	List<Trayecto> buscarTrayectos(Long miembroId);
}
