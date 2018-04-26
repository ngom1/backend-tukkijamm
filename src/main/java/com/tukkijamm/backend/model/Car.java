package com.tukkijamm.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author mamadou
 *
 */
@Entity
@Table(name = "CAR")
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	// car immatriculation number
	@Column(name = "IMMATRICULATION_NUMBER")
	private String immatriculationNumber;
	
	// car brand
	@Column(name = "BRAND")
	private String brand;
	
	// car mode
	@Column(name = "MODEL")
	private String model;
	
	// car color
	@Column(name = "COLOR")
	private String color;
	
	// car owner
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTICULIER_ID")
	private Particulier particulier;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, String immatriculationNumber, String brand, String model, String color) {
		super();
		this.id = id;
		this.immatriculationNumber = immatriculationNumber;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((immatriculationNumber == null) ? 0 : immatriculationNumber.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (immatriculationNumber == null) {
			if (other.immatriculationNumber != null)
				return false;
		} else if (!immatriculationNumber.equals(other.immatriculationNumber))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", immatriculationNumber=" + immatriculationNumber + ", brand=" + brand + ", model="
				+ model + ", color=" + color + "]";
	}

}
