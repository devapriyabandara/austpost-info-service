/*
	This class is the main entry point and which initialize spring boot auto configurations
	and execute location information application
 */
package com.austpost.locationinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationInfoServiceApplication.class, args);
	}

}
