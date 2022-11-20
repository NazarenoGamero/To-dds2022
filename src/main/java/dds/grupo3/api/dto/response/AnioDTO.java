package dds.grupo3.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnioDTO {
	private String numeroAnio;
	private List<mesDTO> mes;
	private Float medicionAnual;
}
