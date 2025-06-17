package com.microservices.user_service.Config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

        @Bean
		@LoadBalanced
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
}