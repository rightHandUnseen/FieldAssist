package org.rightHand.FieldAssistant.translation.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SupportedLocale {

	@EmbeddedId
	private LocaleIdentity localeIdentity;

	@Column(unique = true)
	private String name;

	public SupportedLocale() {
	}

	public SupportedLocale(LocaleIdentity localeIdentity, String name) {

		this.localeIdentity = localeIdentity;
		this.name = name;
	}

	public LocaleIdentity getLocaleIdentity() {
		return localeIdentity;
	}

	public void setLocaleIdentity(LocaleIdentity localeIdentity) {
		this.localeIdentity = localeIdentity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
