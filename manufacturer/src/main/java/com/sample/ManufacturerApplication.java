package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.sample.repository")
public class ManufacturerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerApplication.class, args);
	}
}
