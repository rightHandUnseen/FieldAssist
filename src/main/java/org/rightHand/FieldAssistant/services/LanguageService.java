package org.rightHand.FieldAssistant.services;

import java.util.List;

import org.rightHand.FieldAssistant.model.Language;
import org.rightHand.FieldAssistant.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	public Language save(Language language) {
		if (!languageRepository.existsByIsocode(language.getIsocode())) {
			return languageRepository.saveAndFlush(language);
		} else
			return null;
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
