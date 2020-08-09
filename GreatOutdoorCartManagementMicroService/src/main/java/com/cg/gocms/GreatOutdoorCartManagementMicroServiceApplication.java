package com.cg.gocms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg.gocms.service")
@EnableEurekaClient
public class GreatOutdoorCartManagementMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorCartManagementMicroServiceApplication.class, args);
	}

}
