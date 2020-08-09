package com.cg.gowms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg.gowms.service")
@EnableEurekaClient
public class GreatOutdoorWishlistManagementMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorWishlistManagementMicroServiceApplication.class, args);
	}

}
