package org.rightHand.FieldAssistant.translation.repository;

import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportedLocaleRepository extends JpaRepository<SupportedLocale, Long>{

	boolean existsById(int id);
	
}
