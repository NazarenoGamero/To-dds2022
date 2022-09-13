package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LocalidadDTO;
import dds.grupo3.api.dto.request.MunicipioDTO;
import dds.grupo3.api.dto.request.PaisDTO;
import dds.grupo3.api.dto.request.ProvinciaDTO;
import dds.grupo3.api.service.GeoddsService;
import java.util.List;

public class GeoddsServiceImpl implements GeoddsService {

  private String token= "2gSCEk8R7REUaVp5KuT6S2GxOo8dauKwuxuMJDQw8JA=";

  @Override
  public List<PaisDTO> paises(String token, Integer id) {

    return null;
  }

  @Override
  public List<ProvinciaDTO> provincias(String token, Integer id) {
    return null;
  }

  @Override
  public List<ProvinciaDTO> provincias(String token, int offset, int paisId) {
    return null;
  }

  @Override
  public List<MunicipioDTO> municipios(int offset) {
    return null;
  }

  @Override
  public List<MunicipioDTO> municipios(int offset, int provinciaId) {
    return null;
  }

  @Override
  public List<LocalidadDTO> localidades(int offset) {
    return null;
  }

  @Override
  public List<LocalidadDTO> localidades(int offset, int provinciaId) {
    return null;
  }

  @Override
  public DistanciaDTO distancia(int localidadOrigenId, String calleOrigen, String alturaOrigen,
                                int localidadDestinoId, String calleDestino, String alturaDestino) {
    return null;
  }
}
