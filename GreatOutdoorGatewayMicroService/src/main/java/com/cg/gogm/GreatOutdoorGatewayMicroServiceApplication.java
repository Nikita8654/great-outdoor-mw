package com.cg.gogm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GreatOutdoorGatewayMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorGatewayMicroServiceApplication.class, args);
	}

}
