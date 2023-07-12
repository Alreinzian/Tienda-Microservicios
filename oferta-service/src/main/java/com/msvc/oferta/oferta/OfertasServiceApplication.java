package com.msvc.oferta.oferta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OfertasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfertasServiceApplication.class, args);
	}

}
