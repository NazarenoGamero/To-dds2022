package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LocalidadDTO;
import dds.grupo3.api.dto.request.MunicipioDTO;
import dds.grupo3.api.dto.request.PaisDTO;
import dds.grupo3.api.dto.request.ProvinciaDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Geodds", url="https://ddstpa.com.ar/api/")
public interface GeoddsService {

  @GetMapping(value="paises")
  public List<PaisDTO> paises (@RequestHeader String token, @RequestParam("offset") Integer id);

  @GetMapping(value="provincias")
  public List<ProvinciaDTO> provincias (@RequestHeader String token, @RequestParam("offset") Integer id);

  @GetMapping("provincias")
  public List<ProvinciaDTO> provincias(@RequestHeader String token, @RequestParam("offset") int offset, @RequestParam("paisId") int paisId);

  @GetMapping("municipios")
  public List<MunicipioDTO> municipios(@RequestParam("offset") int offset);

  @GetMapping("municipios")
  public List<MunicipioDTO> municipios(@RequestParam("offset") int offset,
                                   @RequestParam("provinciaId") int provinciaId);

  @GetMapping("localidades")
  public List<LocalidadDTO> localidades(@RequestParam("offset") int offset);

  @GetMapping("localidades")
  public List<LocalidadDTO> localidades(@RequestParam("offset") int offset,
                                    @RequestParam("municipioId") int provinciaId);

  @GetMapping("distancia")
  public DistanciaDTO distancia(@RequestParam("localidadOrigenId") int localidadOrigenId,
                                @RequestParam("calleOrigen") String calleOrigen,
                                @RequestParam("alturaOrigen") String alturaOrigen,
                                @RequestParam("localidadDestinoId") int localidadDestinoId,
                                @RequestParam("calleDestino") String calleDestino,
                                @RequestParam("alturaDestino") String alturaDestino);

}