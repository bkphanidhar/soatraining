package com.sg.training.spring.cloud.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sg.training.spring.cloud.OrderMSCircuitBreaker;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderMSCircuitBreaker.class)
public class ManufacturerMicroServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
