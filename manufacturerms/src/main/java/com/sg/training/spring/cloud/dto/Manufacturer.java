package com.sg.training.spring.cloud.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "manufacturer")
public class Manufacturer {

	@Id
	private int id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdOn;

	private List<Order> orders;

	public Manufacturer() {
	}

	public Manufacturer(int id, String name, Date createdOn) {
		super();
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
	}

	public Manufacturer(int id, String name, Date createdOn, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
