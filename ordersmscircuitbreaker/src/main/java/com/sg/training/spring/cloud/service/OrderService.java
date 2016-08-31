package com.sg.training.spring.cloud.service;

import java.util.List;

import com.sg.training.spring.cloud.dto.Order;

public interface OrderService {
	
	public List<Order> findAll();

	public List<Order> findAllOrdersByManufacturer(Integer id);

	public Order findOne(Integer id);

	public void save(Order myDto);

	public void delete(Integer id);

}
