package com.sneha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sneha.validatorInterface.FuelType;
import com.sneha.validatorInterface.Name;
import com.sneha.validatorInterface.YearOfManufacture;

@Entity
@Table
public class Cars {
	@Id
	@Column
	private int carid;
	
	@Column
	@Name
	@Size(min=2, message="Name should have atleast 2 characters")
	@NotEmpty(message="Name cannot be empty")
	@NotNull(message="Car Name cannot be null")
	private String carname;
	
	
	@Column
	private double price;
	
	@Column
	private String model;
	
	@Column
	@YearOfManufacture
	private Integer yearOfManufacture;
	
	@Column
	@FuelType
	private String fuelType; 
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(Integer yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	
	

}
