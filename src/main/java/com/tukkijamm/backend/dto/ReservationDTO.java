package com.tukkijamm.backend.dto;

public class ReservationDTO {
	private Long id;
	private Boolean status;
	private String deletedOwner;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
