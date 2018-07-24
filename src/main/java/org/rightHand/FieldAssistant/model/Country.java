package org.rightHand.FieldAssistant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

	
	private String isoname;
	@Id
	private String isocode;
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
	
	
	
}
