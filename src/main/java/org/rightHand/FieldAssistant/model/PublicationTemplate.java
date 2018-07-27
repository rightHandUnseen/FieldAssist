package org.rightHand.FieldAssistant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PublicationTemplate {

	@Id
	private String code;
	private String englishname;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}



}
