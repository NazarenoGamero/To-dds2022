package dds.grupo3;

import dds.grupo3.api.service.impl.EmailServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DdsGrupo3Application {

	public static void main(String[] args) {
		SpringApplication.run(DdsGrupo3Application.class, args);
		new EmailServiceImpl().enviarMensaje("mopup2017@gmail.com", "Su huella de carbono es de 9000");
	}

}
