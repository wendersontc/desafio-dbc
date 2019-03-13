package br.com.desafio.dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class DesafioDbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDbcApplication.class, args);
	}

}
