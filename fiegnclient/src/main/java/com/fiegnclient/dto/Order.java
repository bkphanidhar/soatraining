package com.fiegnclient.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {

	private int id;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date orderedOn;
	
	public Order() {
	}
	
	public Order(int id, String name, Date orderedOn) {
		super();
		this.id = id;
		this.name = name;
		this.orderedOn = orderedOn;
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
	
}
