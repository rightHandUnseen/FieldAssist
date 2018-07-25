package org.rightHand.FieldAssistant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Congregation {

	private String name;
	@Id
	private int id;
	@ManyToOne
	private City city;
	@ManyToMany
	@JoinTable(name = "CONGREGATION_LANGUAGE", joinColumns = { @JoinColumn(name = "LANGUAGE_ISOCODE") }, inverseJoinColumns = {
			@JoinColumn(name = "CONGREGATION_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "CONGREGATION_ID",
					"LANGUAGE_ISOCODE" }, name =  "UK_CONGREGATION_LANGUAGE"))
	private List<Language> languages;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
