package com.msvc.oferta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OfertaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfertaServiceApplication.class, args);
	}

}
