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
@Table(name = "PAYMENT")
public class Paiement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8200085859846096508L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RESERVATION_ID", unique = true, nullable = true, insertable = true, updatable = true)
	private Reservation reservation;
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paiement(long id, Reservation reservation) {
		super();
		this.id = id;
		this.reservation = reservation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "Paiement [id=" + id + ", reservation=" + reservation + "]";
	}
	
	
	
}
