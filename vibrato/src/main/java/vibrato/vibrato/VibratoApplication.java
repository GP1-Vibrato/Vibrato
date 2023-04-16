package vibrato.vibrato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"vibrato.vibrato.api.configuration.security.services.autenticacao.OuvinteAutenticacaoService"})
@SpringBootApplication
public class VibratoApplication {
	public static void main(String[] args) {
		SpringApplication.run(VibratoApplication.class, args);
	}



}
