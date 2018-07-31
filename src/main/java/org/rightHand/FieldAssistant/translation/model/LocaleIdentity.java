package org.rightHand.FieldAssistant.translation.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.rightHand.FieldAssistant.model.Language;

@Embeddable
public class LocaleIdentity implements Serializable {

	private static final long serialVersionUID = -2855867329555433981L;
	@ManyToOne
	private Language language;
	@ManyToOne
	private Region region;

	public LocaleIdentity() {

	}

	public LocaleIdentity(Language language, Region region) {
		this.region = region;
		this.language = language;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
