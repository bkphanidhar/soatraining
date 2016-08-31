package com.sg.training.spring.cloud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sg.training.spring.cloud.dto.Order;


public interface OrderRepository extends MongoRepository<Order,Integer> {
	
	@Query("{'manufacturerId':?0}")
	public List<Order> findAllOrdersByManufacturer(Integer manufacturerId);

}
