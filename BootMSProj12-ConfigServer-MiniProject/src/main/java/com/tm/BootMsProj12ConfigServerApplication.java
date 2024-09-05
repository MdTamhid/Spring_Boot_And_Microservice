package com.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj12ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj12ConfigServerApplication.class, args);
	}

}
