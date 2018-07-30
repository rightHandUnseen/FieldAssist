package org.rightHand.FieldAssistant.translation.service;

import java.util.List;

import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.rightHand.FieldAssistant.translation.repository.SupportedLocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportedLocaleService {

	@Autowired
	private SupportedLocaleRepository supportedLocaleRepository;
	
	public SupportedLocale save (SupportedLocale supportedLocale) {
		if(!supportedLocaleRepository.existsById( supportedLocale.getId())) {
			return supportedLocaleRepository.saveAndFlush(supportedLocale);
		}
		else return null;
	}
	
	public List<SupportedLocale> listAll(){
		return supportedLocaleRepository.findAll();
	}
	
	public SupportedLocale findOne(Long id) {
		return supportedLocaleRepository.getOne( id);
	}
	
	public void delete(Long id) {
		supportedLocaleRepository.deleteById(id);
	}
	
}
