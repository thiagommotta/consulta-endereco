package com.projects.java.consultaendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsultaEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaEnderecoApplication.class, args);
	}

}
