package com.sg.training.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.training.spring.cloud.client.OrderClient;
import com.sg.training.spring.cloud.dto.Manufacturer;
import com.sg.training.spring.cloud.dto.Order;
import com.sg.training.spring.cloud.repository.ManufacturerRepo;

@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerRepo repo;
	
	@Autowired
	private OrderClient orderClient;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Manufacturer>> findAll() {
		return new ResponseEntity<List<Manufacturer>>(repo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Manufacturer> find(@PathVariable Integer id) {
		Manufacturer manufacturer = repo.findOne(id);
		manufacturer.setOrders(orderClient.findAllOrdersByManufacturer(id));
		return new ResponseEntity<Manufacturer>(manufacturer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Manufacturer> add(@RequestBody Manufacturer myDto) {
		repo.save(myDto);
		return new ResponseEntity<Manufacturer>(myDto, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Manufacturer> update(@PathVariable Integer id, @RequestBody Manufacturer updatedDto) {
		Manufacturer needToUpdate;
		if ((needToUpdate = repo.findOne(id)) != null) {
			needToUpdate.setCreatedOn(updatedDto.getCreatedOn());
			needToUpdate.setName(updatedDto.getName());
			repo.save(needToUpdate);
		}
		ResponseEntity<Manufacturer> resp = null;
		if (null == needToUpdate) {
			resp = new ResponseEntity<Manufacturer>(updatedDto, HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<Manufacturer>(needToUpdate, HttpStatus.OK);
		}
		return resp;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable(value = "id") Integer id) {
		Manufacturer needToDelete;
		if ((needToDelete = repo.findOne(id)) != null) {
			repo.delete(id);
		}
		ResponseEntity<Integer> resp = null;
		if (null == needToDelete) {
			resp = new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		return resp;
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findOrder(@PathVariable Integer id) {
		return new ResponseEntity<Order>(orderClient.find(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAllOrders() {
		return new ResponseEntity<List<Order>>(orderClient.findAllOrders(), HttpStatus.OK);
	}
}
