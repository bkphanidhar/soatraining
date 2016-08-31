package com.fiegnclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiegnclient.client.OrderClient;
import com.fiegnclient.dto.Order;

@RestController
@RequestMapping(value = "/fiegn")
public class OrderController {

	@Autowired
	private OrderClient client;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAll() {
		ResponseEntity<List<Order>> resp = null;
		List<Order> orders = client.findAllOrders();
		if (null != orders) {
			resp = new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}

	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> find(@PathVariable Integer id) {
		ResponseEntity<Order> resp = null;
		Order order = client.find(id);
		if (null != order) {
			resp = new ResponseEntity<Order>(order, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}
}
