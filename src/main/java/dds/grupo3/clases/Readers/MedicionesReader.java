package dds.grupo3.clases.Readers;

import dds.grupo3.clases.Medible.Medible;

import java.util.List;

public interface MedicionesReader {
	public List<Medible> leerArchivoMediciones(String path);
}