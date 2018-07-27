package org.rightHand.FieldAssistant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String contactName;
	@ManyToOne
	private Country country;
	@ManyToMany
	@JoinTable(name = "CONTACT_LANGUAGE", joinColumns = { @JoinColumn(name = "LANGUAGE_ISOCODE") }, inverseJoinColumns = {
			@JoinColumn(name = "CONTACT_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "CONTACT_ID",
					"LANGUAGE_ISOCODE" }, name =  "UK_CONTACT_LANGUAGE"))
	private List<Language> languages;
	@ManyToOne
	private Language motherLanguage;
	@ManyToMany
	@JoinTable(name = "CONTACT_ADDRESS", joinColumns = { @JoinColumn(name = "CONTACT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ADDRESS_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "ADDRESS_ID",
					"CONTACT_ID" }, name =  "UK_CONGREGATION_LANGUAGE"))
	private List<Address> addresses;
	@OneToMany
	private List<Note> notes;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public Language getMotherLanguage() {
		return motherLanguage;
	}
	public void setMotherLanguage(Language motherLanguage) {
		this.motherLanguage = motherLanguage;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
