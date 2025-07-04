package com.microservices.rating_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hi");
		SpringApplication.run(RatingServiceApplication.class, args);
		System.out.println("Hello");
	}

}
