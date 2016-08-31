package com.sg.training.spring.cloud.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {

	private int id;
	private String name;
	private int manufacturerId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date orderedOn;
	 
	
	public Order() {
	}
	
	public Order(int id, String name, int manufacturerId, Date orderedOn) {
		super();
		this.id = id;
		this.name = name;
		this.orderedOn = orderedOn;
		this.manufacturerId = manufacturerId;
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
	public Date getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
}
