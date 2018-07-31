package org.rightHand.FieldAssistant.translation.repository;

import java.util.Locale;

import org.rightHand.FieldAssistant.translation.model.LocaleIdentity;
import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportedLocaleRepository extends JpaRepository<SupportedLocale, LocaleIdentity> {

	@Query("SELECT sl FROM SupportedLocale sl WHERE LOWER(sl.localeIdentity.language) = LOWER(:#{#locale.language}) AND LOWER(sl.localeIdentity.region) = LOWER(:#{#locale.country})")
	SupportedLocale findByLocale(@Param("locale") Locale locale);

	boolean existsById(LocaleIdentity id);
	
	SupportedLocale findByLocaleIdentity(LocaleIdentity id);
	
	SupportedLocale findByName(String name);

}
