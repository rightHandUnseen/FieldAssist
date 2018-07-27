package org.rightHand.FieldAssistant.systemsettings.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Setting implements Serializable {

	private static final long serialVersionUID = 7340255545166662599L;
	@Id
	private String sectionName;
	@Id
	private String settingName;

	private String settingType;
	@Column(columnDefinition = "Tinyint(1) default '1'")
	private boolean active;

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getSettingType() {
		return settingType;
	}

	public void setSettingType(String settingType) {
		this.settingType = settingType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
