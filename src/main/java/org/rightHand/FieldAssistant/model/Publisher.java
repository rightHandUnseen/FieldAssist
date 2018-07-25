package org.rightHand.FieldAssistant.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.rightHand.FieldAssistant.model.enums.Gender;

@Entity

public class Publisher implements Serializable{

	
	private static final long serialVersionUID = -6373518555898566135L;
	@Id
	@JoinColumn(name="user_id")
	@OneToOne
	private User user;
	@NotBlank
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToOne
	private Congregation congregation;
	@ManyToMany
	@JoinTable(name = "PUBLISHER_LANGUAGE", joinColumns = { @JoinColumn(name = "LANGUAGE_ISOCODE") }, inverseJoinColumns = {
			@JoinColumn(name = "PUBLISER_USER_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "PUBLISER_USER_ID",
					"LANGUAGE_ISOCODE" }, name =  "UK_PUBLISHER_LANGUAGE"))
	private List<Language> languages;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Congregation getCongregation() {
		return congregation;
	}
	public void setCongregation(Congregation congregation) {
		this.congregation = congregation;
	}
	
	
}
