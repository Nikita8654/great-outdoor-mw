package com.cg.goim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg.goim.service")
@EnableEurekaClient
public class GreatOutdoorInventoryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorInventoryMicroServiceApplication.class, args);
	}

}
