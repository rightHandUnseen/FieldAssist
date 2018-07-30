package org.rightHand.FieldAssistant.translation.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MessageIdentity implements Serializable{

	private static final long serialVersionUID = 5681129371007286056L;
	
	@ManyToOne
	private DefaultMessage defaultMessage;
	@ManyToOne
	private SupportedLocale locale;
	
	
	public MessageIdentity() {}

	public MessageIdentity(DefaultMessage defaultMessage, SupportedLocale locale) {
		super();
		this.defaultMessage = defaultMessage;
		this.locale = locale;
	}

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
	
	
	
	
}
