package org.rightHand.FieldAssistant.translation.service;

import java.util.List;
import java.util.Optional;

import org.rightHand.FieldAssistant.translation.model.LocaleIdentity;
import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.rightHand.FieldAssistant.translation.repository.SupportedLocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportedLocaleService {

	@Autowired
	private SupportedLocaleRepository supportedLocaleRepository;
	
	public SupportedLocale save (SupportedLocale supportedLocale) {
		Optional<SupportedLocale> innerLocale = supportedLocaleRepository.findById(supportedLocale.getLocaleIdentity());
		if(!innerLocale.isPresent()) {
			return supportedLocaleRepository.saveAndFlush(supportedLocale);
		}
		else return innerLocale.get();
	}
	
	public List<SupportedLocale> listAll(){
		return supportedLocaleRepository.findAll();
	}
	
	public SupportedLocale findOne(LocaleIdentity id) {
		return supportedLocaleRepository.findByLocaleIdentity(id);
	}
	
	public void delete(LocaleIdentity id) {
		supportedLocaleRepository.deleteById(id);
	}
	
	public SupportedLocale findByName(String name) {
		return supportedLocaleRepository.findByName(name);
	}
	
}
