package org.rightHand.FieldAssistant.repositories;

import org.rightHand.FieldAssistant.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String>{

	boolean existsByIsocode(String isocode);
	
}
