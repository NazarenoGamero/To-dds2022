package dds.grupo3.api.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="Gmail API", url="https://ejemplo.com.ar/")
public interface GmailAPI {

	@GetMapping(value="/enviarEmail")
	public void enviarEmail(
			@RequestHeader String token,
			@RequestHeader String algo,
			@RequestBody String mensaje);
	
	//Esto sería un ejemplo para consumir una API REST sencilla
}
