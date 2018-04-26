package com.tukkijamm.backend.RequestBeans;

import com.tukkijamm.backend.model.Publication;

/**
 * 
 * @author mamadou
 *
 */
public class PublicationRequestParam {
	
	//particulier Id
	private Long id;
	//publication
	private Publication publication;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	
}
