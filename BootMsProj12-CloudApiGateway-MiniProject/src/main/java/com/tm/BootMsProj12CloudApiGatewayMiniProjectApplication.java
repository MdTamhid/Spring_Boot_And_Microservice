package com.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj12CloudApiGatewayMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj12CloudApiGatewayMiniProjectApplication.class, args);
	}

}
