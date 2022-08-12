package dds.grupo3.clases.readers;

import java.util.List;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;

public interface MedicionesReader {
  public List<Medible> leerArchivoMediciones(String path, List<FactorEmision> factores);
}