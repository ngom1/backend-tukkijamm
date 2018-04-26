package com.tukkijamm.backend.RequestBeans;

public class TripRequestParam {
	//reservation Id
	private Long reservationId;
	//comments to a trip
	private String comments;
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
