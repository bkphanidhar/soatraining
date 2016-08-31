package com.sg.training.spring.cloud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.training.spring.cloud.dto.Order;
import com.sg.training.spring.cloud.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = service.findAll();
		orders.add(new Order(4, "Sam", 1, new Date()));
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/manufacturer/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAllOrdersByManufacturer(@PathVariable Integer id) {
		return new ResponseEntity<List<Order>>(service.findAllOrdersByManufacturer(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> find(@PathVariable Integer id) {
		ResponseEntity<Order> response = null;
		Order order = null;
		if ((order = service.findOne(id)) != null) {
			response = new ResponseEntity<Order>(order, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Order> add(@RequestBody Order myDto) {
		service.save(myDto);
		return new ResponseEntity<Order>(myDto, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Order> update(@PathVariable Integer id, @RequestBody Order updatedDto) {
		Order needToUpdate;
		if ((needToUpdate = service.findOne(id)) != null) {
			needToUpdate.setOrderedOn(updatedDto.getOrderedOn());
			needToUpdate.setName(updatedDto.getName());
			needToUpdate.setManufacturerId(updatedDto.getManufacturerId());
			service.save(needToUpdate);
		}
		ResponseEntity<Order> resp = null;
		if (null == needToUpdate) {
			resp = new ResponseEntity<Order>(updatedDto, HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<Order>(needToUpdate, HttpStatus.OK);
		}
		return resp;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable(value = "id") Integer id) {
		Order needToDelete;
		if ((needToDelete = service.findOne(id)) != null) {
			service.delete(id);
		}
		ResponseEntity<Integer> resp = null;
		if (null == needToDelete) {
			resp = new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		return resp;
	}

}
