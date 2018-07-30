package org.rightHand.FieldAssistant.translation.service;

import java.util.List;

import org.rightHand.FieldAssistant.translation.model.MessageIdentity;
import org.rightHand.FieldAssistant.translation.model.TranslatedMessage;
import org.rightHand.FieldAssistant.translation.repository.TranslatedMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslatedMessageService {

	@Autowired
	private TranslatedMessageRepository translatedMessageRepository;
	
	public TranslatedMessage save (TranslatedMessage translatedMessage) {
		if(!translatedMessageRepository.existsById(translatedMessage.getMessageIdentity())) {
			return translatedMessageRepository.saveAndFlush(translatedMessage);
		}
		else return null;
	}
	
	public List<TranslatedMessage> listAll(){
		return translatedMessageRepository.findAll();
	}
	
	public TranslatedMessage findOne(MessageIdentity id) {
		return translatedMessageRepository.getOne( id);
	}
	
	public void delete(MessageIdentity id) {
		translatedMessageRepository.deleteById(id);
	}
	
}
