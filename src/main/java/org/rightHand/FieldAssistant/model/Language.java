package org.rightHand.FieldAssistant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language {

	private String isoname;
	@Id
	private String isocode;
	@Column(unique = true)
	private String jwcode;

	public String getIsoname() {
		return isoname;
	}

	public void setIsoname(String isoname) {
		this.isoname = isoname;
	}

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}

	public String getJwcode() {
		return jwcode;
	}

	public void setJwcode(String jwcode) {
		this.jwcode = jwcode;
	}

}
