package com.sg.training.spring.cloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sg.training.spring.cloud.dto.Order;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(path = "/getOrders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getData() {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("order-micorservice");
		if (!CollectionUtils.isEmpty(serviceInstances)) {
			URI uri = serviceInstances.get(0).getUri();
			if (null != uri) {
				return new ResponseEntity<List<Order>>(
						(new RestTemplate()).getForObject(uri.toString() + "/order", List.class), HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Order>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<String> postData(@RequestBody Order order) {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("order-micorservice");
		if (!CollectionUtils.isEmpty(serviceInstances)) {
			URI uri = serviceInstances.get(0).getUri();
			if (null != uri) {
				return new ResponseEntity<String>(
						(new RestTemplate()).postForObject(uri + "/order", order, String.class), HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

}
