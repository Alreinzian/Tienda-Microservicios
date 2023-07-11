package com.msvc.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class tiendaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(tiendaServiceApplication.class, args);
	}

}
