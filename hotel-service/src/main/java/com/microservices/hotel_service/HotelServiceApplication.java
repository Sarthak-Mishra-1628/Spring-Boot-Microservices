package com.microservices.hotel_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hi");
		SpringApplication.run(HotelServiceApplication.class, args);
		System.out.println("Hello");
	}

}
