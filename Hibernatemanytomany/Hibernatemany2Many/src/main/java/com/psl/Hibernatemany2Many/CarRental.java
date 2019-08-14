package com.psl.Hibernatemany2Many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="carRental")
public class CarRental {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carId;
	private String carNumber;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="carRentals")
	private List<UserDetails> userDetails;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public List<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
}
