package com.sample.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Manufacturer {

	private int id;

	private String name;

	private Date foundedOn;

	private boolean isActive;

	public Manufacturer() {

	}

	public Manufacturer(int id, String name, Date foundedOn, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.foundedOn = foundedOn;
		this.isActive = isActive;
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

	public Date getFoundedOn() {
		return foundedOn;
	}

	public void setFoundedOn(Date foundedOn) {
		this.foundedOn = foundedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foundedOn == null) ? 0 : foundedOn.hashCode());
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		if (foundedOn == null) {
			if (other.foundedOn != null)
				return false;
		} else if (!foundedOn.equals(other.foundedOn))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", foundedOn=" + foundedOn + ", isActive=" + isActive
				+ "]";
	}

}
