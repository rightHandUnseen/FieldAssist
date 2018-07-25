package org.rightHand.FieldAssistant.translation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TranslatedMessage implements Serializable{
	
	private static final long serialVersionUID = 4855102024833517948L;
	@Id
	@ManyToOne
	private DefaultMessage defaultMessage;
	@Id
	@ManyToOne
	private SupportedLocale locale;
	private String messageValue;

	public DefaultMessage getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(DefaultMessage defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public SupportedLocale getLocale() {
		return locale;
	}

	public void setLocale(SupportedLocale locale) {
		this.locale = locale;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

}
