package com.sg.training.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.sg.training.spring.cloud.repository")
@EnableDiscoveryClient
@EnableFeignClients
public class ManufacturerMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMicroServiceApplication.class, args);
	}
}
