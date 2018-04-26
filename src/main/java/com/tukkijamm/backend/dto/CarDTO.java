package com.tukkijamm.backend.dto;



import com.tukkijamm.backend.model.Particulier;

public class CarDTO {
	private Long id;
	// car immatriculation number
	private String immatriculationNumber;
	// car brand
	private String brand;
	// car mode
	private String model;
	// car color
	private String color;
	// car owner
	private Particulier particulier;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImmatriculationNumber() {
		return immatriculationNumber;
	}
	public void setImmatriculationNumber(String immatriculationNumber) {
		this.immatriculationNumber = immatriculationNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Particulier getParticulier() {
		return particulier;
	}
	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}
	
	
}
