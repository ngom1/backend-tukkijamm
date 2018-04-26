package com.tukkijamm.backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author mamadou
 *
 */
@Entity
@Table(name = "TRIP")
public class Trip implements Serializable {
	private static final long serialVersionUID = 5335541198312543904L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "COMMENTS")
	private String avis;

	// le voyage a forcement une reservation car on peut reserver snns voyager

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RESERVATION_ID", unique = true, nullable = true, insertable = true, updatable = true)
	private Reservation reservation;

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trip(long id, String avis, Reservation reservation) {
		super();
		this.id = id;
		this.avis = avis;
		this.reservation = reservation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", avis=" + avis + ", reservation=" + reservation + "]";
	}

}
