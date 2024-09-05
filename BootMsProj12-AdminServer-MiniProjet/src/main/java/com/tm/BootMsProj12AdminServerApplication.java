package com.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class BootMsProj12AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj12AdminServerApplication.class, args);
	}

}
