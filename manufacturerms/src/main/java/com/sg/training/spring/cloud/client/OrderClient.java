package com.sg.training.spring.cloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sg.training.spring.cloud.dto.Order;


@FeignClient("order-micorservice")
@RequestMapping(value = "/order")
public interface OrderClient {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Order> findAllOrders();

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Order find(@PathVariable(value = "id") Integer id);
	
	@RequestMapping(value = "/manufacturer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Order> findAllOrdersByManufacturer(@PathVariable(value = "id") Integer id);
}
