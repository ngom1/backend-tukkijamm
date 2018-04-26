package com.tukkijamm.backend.dto;

import java.io.Serializable;
import java.util.Date;

public class PublicationDTO implements Serializable{
		
		private static final long serialVersionUID = 7394219316787916879L;
		private long id;
		private String departure;
		private String arrival;
		private Date tripDate;
		private Date publicationDate;
		private Double price;
		private Integer availablePlaceNumber;
		private String description;
		private Boolean status;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		} 
}
