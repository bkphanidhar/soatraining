package com.sg.training.spring.cloud;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
public class OrderAPIGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAPIGateWayApplication.class, args);
	}
	
	@Bean
	public Filter shallowEragHeaderFilter(){
		return new ShallowEtagHeaderFilter();
	}
}
