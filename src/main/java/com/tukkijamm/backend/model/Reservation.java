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
@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1461641841391158643L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="STATUS")
	private Boolean status;
	
	@Column(name="DELETED_BY")
	private String deletedOwner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTICULIER_ID")
	private Particulier particulier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUBLICATION_ID")
	private Publication publication;
	
	public Reservation() {
		super();
	}
	
	public Reservation(Long id, Particulier particulier, Publication publication) {
		super();
		this.id = id;
		this.particulier = particulier;
		this.publication = publication;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Particulier getParticulier() {
		return particulier;
	}
	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getDeletedOwner() {
		return deletedOwner;
	}
	public void setDeletedOwner(String deletedOwner) {
		this.deletedOwner = deletedOwner;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", particulier=" + particulier + ", publication=" + publication + "]";
	}
	
}
