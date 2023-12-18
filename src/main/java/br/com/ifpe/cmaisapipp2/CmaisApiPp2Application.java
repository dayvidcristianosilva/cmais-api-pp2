package br.com.ifpe.cmaisapipp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CmaisApiPp2Application {

	public static void main(String[] args) {
		SpringApplication.run(CmaisApiPp2Application.class, args);
	}
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
    }


}
