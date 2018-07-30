package org.rightHand.FieldAssistant.translation.service;

import java.util.List;

import org.rightHand.FieldAssistant.translation.model.DefaultMessage;
import org.rightHand.FieldAssistant.translation.repository.DefaultMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMessageService {

	@Autowired
	private DefaultMessageRepository defaultMessageRepository;
	
	public DefaultMessage save (DefaultMessage defaultMessage) {
		if(!defaultMessageRepository.existsByMessageCode(defaultMessage.getMessageCode())) {
			return defaultMessageRepository.saveAndFlush(defaultMessage);
		}
		else return null;
	}
	
	public List<DefaultMessage> listAll(){
		return defaultMessageRepository.findAll();
	}
	
	public DefaultMessage findOne(Long id) {
		return defaultMessageRepository.getOne(id);
	}
	
	public void delete(Long id) {
		defaultMessageRepository.deleteById(id);
	}
	
	public DefaultMessage findByMessageCode(String messageCode) {
		return defaultMessageRepository.findByMessageCode(messageCode);
	}
	
}
