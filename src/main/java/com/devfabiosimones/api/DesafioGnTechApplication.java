package com.devfabiosimones.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioGnTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioGnTechApplication.class, args);
	}

}
