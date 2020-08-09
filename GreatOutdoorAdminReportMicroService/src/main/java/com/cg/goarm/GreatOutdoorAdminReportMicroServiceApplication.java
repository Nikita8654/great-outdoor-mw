package com.cg.goarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg.goarm.service")
@EnableEurekaClient
public class GreatOutdoorAdminReportMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorAdminReportMicroServiceApplication.class, args);
	}

}
