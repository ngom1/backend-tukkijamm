package com.tukkijamm.backend.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ParticulierDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String sex;
	private Date birthday;
	private String telephone;
	private String email;
	private String password;
	private String login;
	private List<CarDTO> cars;
	private List<PublicationDTO> publications;
	private List<ReservationDTO> reservations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public List<CarDTO> getCars() {
		return cars;
	}
	public void setCars(List<CarDTO> cars) {
		this.cars = cars;
	}
	public List<PublicationDTO> getPublications() {
		return publications;
	}
	public void setPublications(List<PublicationDTO> publications) {
		this.publications = publications;
	}
	public List<ReservationDTO> getReservations() {
		return reservations;
	}
	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}
}
