package org.rightHand.FieldAssistant.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
public class Visit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany
	private List<Publication> publications;
	private String observation;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date hour;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Publisher.class)
	@JoinTable(name = "VISIT_PUBLISHER", joinColumns = { @JoinColumn(name = "VISIT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PUBLISHER_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "VISIT_ID",
					"PUBLISHER_ID" }, name =  "UK_VISIT_PUBLISHER"))

	private Set<Publisher> publishers;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Publisher.class)
	@JoinTable(name = "VISIT_CONTACT", joinColumns = { @JoinColumn(name = "VISIT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CONTACT_ID") }, uniqueConstraints = @UniqueConstraint(columnNames = { "VISIT_ID",
					"CONTACT_ID" }, name =  "UK_VISIT_CONTACT"))

	private Set<Contact> contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	

}
