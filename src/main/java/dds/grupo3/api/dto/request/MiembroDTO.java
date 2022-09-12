package dds.grupo3.api.dto.request;

import dds.grupo3.clases.miembro.TipoDocEnum;
import dds.grupo3.clases.organizacion.Clasificacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.organizacion.TipoOrg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MiembroDTO {
	private String nombre;
	private String apellido;
	private TipoDocEnum tipoDoc;
	private Long nroDoc;
}
