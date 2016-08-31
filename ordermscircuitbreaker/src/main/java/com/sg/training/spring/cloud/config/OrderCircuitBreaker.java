package com.sg.training.spring.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class OrderCircuitBreaker {

	@Autowired
	private IClientConfig ribbinClientConfig;
	
	@Bean
	public IPing ribbinPing(IClientConfig ribbinClientConfig){
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbinRule(IClientConfig ribbinClientConfig){
		return new AvailabilityFilteringRule();
	}

}
