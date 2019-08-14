package com.psl.Hibernatemany2Many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userDetails")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String address;
	
	@ManyToMany
	private List<CarRental> carRentals;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CarRental> getCarRentals() {
		return carRentals;
	}

	public void setCarRentals(List<CarRental> carRentals) {
		this.carRentals = carRentals;
	}
	
	
	
	
}
