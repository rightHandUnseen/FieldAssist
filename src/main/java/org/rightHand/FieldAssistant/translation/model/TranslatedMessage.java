package org.rightHand.FieldAssistant.translation.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TranslatedMessage implements Serializable {

	private static final long serialVersionUID = 4855102024833517948L;

	@EmbeddedId
	private MessageIdentity messageIdentity;
	private String messageValue;

	public TranslatedMessage() {

	}

	public TranslatedMessage(MessageIdentity messageIdentity, String messageValue) {

		this.messageIdentity = messageIdentity;
		this.messageValue = messageValue;
	}
	
	public TranslatedMessage(MessageIdentity messageIdentity) {
		this.messageIdentity = messageIdentity;
	}

	public MessageIdentity getMessageIdentity() {
		return messageIdentity;
	}

	public void setMessageIdentity(MessageIdentity messageIdentity) {
		this.messageIdentity = messageIdentity;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

}
