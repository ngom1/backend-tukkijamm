package com.tukkijamm.backend.RequestBeans;

import java.util.Date;

public class SearchTripRequestParam {
	private String departure;
	private String arrival;
	private Date tripDate;

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
}
