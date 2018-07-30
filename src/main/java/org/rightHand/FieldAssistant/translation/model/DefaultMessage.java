package org.rightHand.FieldAssistant.translation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DefaultMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String messageCode;

	private String messageValue;

	
	
	public DefaultMessage(String messageCode, String messageValue) {
		super();
		this.messageCode = messageCode;
		this.messageValue = messageValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

}
