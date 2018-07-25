package org.rightHand.FieldAssistant.translation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {
	@Id
	private String regionCode;
	
	private String regionName;

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
}
