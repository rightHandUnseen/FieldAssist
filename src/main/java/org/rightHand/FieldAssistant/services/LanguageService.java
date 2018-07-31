package org.rightHand.FieldAssistant.services;

import java.util.List;
import java.util.Optional;

import org.rightHand.FieldAssistant.model.Language;
import org.rightHand.FieldAssistant.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	public Language save(Language language) {
		Optional<Language> innerLanguage = languageRepository.findById(language.getIsocode());
		if (!innerLanguage.isPresent()) {
			return languageRepository.saveAndFlush(language);
		} else
			return innerLanguage.get();
	}

	public List<Language> listAll() {
		return languageRepository.findAll();
	}

	public Language findOne(String isocode) {
		return languageRepository.getOne(isocode);
	}

	public void delete(String isocode) {
		languageRepository.deleteById(isocode);
	}
	
	

}
