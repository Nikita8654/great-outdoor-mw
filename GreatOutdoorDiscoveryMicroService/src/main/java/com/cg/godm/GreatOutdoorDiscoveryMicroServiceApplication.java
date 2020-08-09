package com.cg.godm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GreatOutdoorDiscoveryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorDiscoveryMicroServiceApplication.class, args);
	}

}
