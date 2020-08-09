package com.cg.goams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GreatOutdoorAddressManagementMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorAddressManagementMicroServiceApplication.class, args);
	}

}
