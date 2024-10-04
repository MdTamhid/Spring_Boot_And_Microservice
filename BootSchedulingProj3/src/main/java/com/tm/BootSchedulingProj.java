package com.tm;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj {

	public static void main(String[] args) {
		
		System.out.println("main(-) application started at:: "+ new Date());
		SpringApplication.run(BootSchedulingProj.class, args);
	}

}
