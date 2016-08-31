package com.sg.training.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.sg.training.spring.cloud.config.CustomLBConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="ribbinConfig",configuration=CustomLBConfig.class)
public class OrderLoadBalancerApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderLoadBalancerApp.class, args);
	}
}
