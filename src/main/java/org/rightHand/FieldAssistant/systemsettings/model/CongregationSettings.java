package org.rightHand.FieldAssistant.systemsettings.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.rightHand.FieldAssistant.model.Congregation;

@Entity
public class CongregationSettings implements Serializable {

	private static final long serialVersionUID = -5035282659303371912L;
	@Id
	@ManyToOne
	private Congregation congregation;
	@Id
	@ManyToOne
	private Setting setting;

	public Congregation getCongregation() {
		return congregation;
	}

	public void setCongregation(Congregation congregation) {
		this.congregation = congregation;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
