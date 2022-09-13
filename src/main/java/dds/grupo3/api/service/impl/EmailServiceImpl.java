package dds.grupo3.api.service.impl;

import dds.grupo3.api.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void enviarMensaje(String mensaje, String email) {
		// TODO Aca va la logica de envio de email
		// Ver interface GmailAPI en el package dds.grupo3.api.service.client
	}

	
}
