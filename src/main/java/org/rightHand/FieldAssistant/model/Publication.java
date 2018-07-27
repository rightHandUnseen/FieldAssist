package org.rightHand.FieldAssistant.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Publication implements Serializable {

	private static final long serialVersionUID = 5086502362316713579L;
	@Id
	@ManyToOne
	private PublicationTemplate publication;
	@Id
	@ManyToOne
	private Language language;
	private String translatedTitle;
	private String revision;

	public PublicationTemplate getPublication() {
		return publication;
	}

	public void setPublication(PublicationTemplate publication) {
		this.publication = publication;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getTranslatedTitle() {
		return translatedTitle;
	}

	public void setTranslatedTitle(String translatedTitle) {
		this.translatedTitle = translatedTitle;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

}
