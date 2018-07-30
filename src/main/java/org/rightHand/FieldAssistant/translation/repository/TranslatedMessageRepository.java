package org.rightHand.FieldAssistant.translation.repository;

import java.util.Locale;

import org.rightHand.FieldAssistant.translation.model.MessageIdentity;
import org.rightHand.FieldAssistant.translation.model.TranslatedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatedMessageRepository extends JpaRepository<TranslatedMessage, MessageIdentity>{


	TranslatedMessage findByMessageIdentity(MessageIdentity messageIdentity);
	
}
