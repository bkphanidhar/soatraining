package com.sg.training.spring.cloud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sg.training.spring.cloud.client.OrderClient;
import com.sg.training.spring.cloud.dto.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderClient orderClient;

	@Override
	@HystrixCommand(fallbackMethod = "findAllFallBack")
	public List<Order> findAll() {
		return orderClient.findAllOrders();
	}

	@Override
	public List<Order> findAllOrdersByManufacturer(Integer id) {
		return orderClient.findAllOrdersByManufacturer(id);
	}

	@Override
	public Order findOne(Integer id) {
		return orderClient.find(id);
	}

	@Override
	public void save(Order order) {
		orderClient.save(order);
	}

	@Override
	public void delete(Integer id) {
		orderClient.delete(id);
	}

	public List<Order> findAllFallBack() {
		List<Order> dummy = new ArrayList<>();
		dummy.add(new Order(5, "Test", 5, new Date()));
		return dummy;
	}

}
