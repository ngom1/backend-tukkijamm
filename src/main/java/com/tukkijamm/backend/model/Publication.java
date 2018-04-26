package com.tukkijamm.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author mamadou
 *
 */
@Entity
@Table(name = "PUBLICATION")
public class Publication implements Serializable{
	
	private static final long serialVersionUID = 7394219316787916879L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "DEPARTURE")
	private String departure;
	
	@Column(name = "ARRIVAL")
	private String arrival;
	
	@Column(name = "TRIP_DATE")
	private Date tripDate;
	
	@Column(name = "PUBLICATION_DDATE")
	private Date publicationDate;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "AVAILABLE_PLACE")
	private Integer availablePlaceNumber;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name="STATUS")
	private Boolean status; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTICULIER_ID")
	private Particulier particulier;
	
	@OneToMany(mappedBy = "publication", 
			cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reservation>reservations;
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publication(long id, String departure, String arrival, Date date, Double price, Integer availablePlaceNumber,
			Particulier particulier) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.tripDate = date;
		this.price = price;
		this.availablePlaceNumber = availablePlaceNumber;
		this.particulier = particulier;
	}

	public Publication(Publication publication) {
		super();
		this.departure = publication.getDeparture();
		this.arrival = publication.getArrival();
		this.tripDate = publication.getTripDate();
		this.price = publication.getPrice();
		this.availablePlaceNumber = publication.getAvailablePlaceNumber();
		this.publicationDate = new Date();
		this.description = publication.getDescription();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public Date getTripDate() {
		return tripDate;
	}
	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAvailablePlaceNumber() {
		return availablePlaceNumber;
	}

	public void setAvailablePlaceNumber(Integer availablePlaceNumber) {
		this.availablePlaceNumber = availablePlaceNumber;
	}

	public Particulier getParticulier() {
		return particulier;
	}

	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", date=" + tripDate
				+ ", price=" + price + ", availablePlaceNumber=" + availablePlaceNumber + "]";
	}

}
