package com.tukkijamm.backend.RequestBeans;

import java.io.Serializable;

import com.tukkijamm.backend.model.Reservation;

/**
 * 
 * @author mamadou
 *
 */
public class ReservationRequestParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//paassenger Id
	private Long passengerId;
	//reservation Id
	private Long publicationId;
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	public Long getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
}
