package com.cg.gops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GreatOutdoorProductMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorProductMicroServiceApplication.class, args);
	}

}
