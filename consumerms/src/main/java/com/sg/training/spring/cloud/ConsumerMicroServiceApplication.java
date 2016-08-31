package com.sg.training.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMicroServiceApplication.class, args);
	}
}
