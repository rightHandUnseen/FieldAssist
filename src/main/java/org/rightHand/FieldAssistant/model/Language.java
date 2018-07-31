package org.rightHand.FieldAssistant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Language {
	@NotNull
	private String isoname;
	@Id
	private String isocode;
	@Column(unique = true)
	private String jwcode;

		
	public Language() {
	}

	public Language(String isoname, String isocode, String jwcode) {
		this.isoname = isoname;
		this.isocode = isocode;
		this.jwcode = jwcode;
	}

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
