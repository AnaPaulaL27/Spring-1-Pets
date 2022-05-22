package com.bnta.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// Entry point of application  Public static void main..
	//calls SpringApplication.run which launches spring framework + passes in a reference to main class- DemoApplication.class


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
