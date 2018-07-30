package org.rightHand.FieldAssistant.translation.repository;

import org.rightHand.FieldAssistant.translation.model.DefaultMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultMessageRepository extends JpaRepository<DefaultMessage, Long> {

	boolean existsByMessageCode(String messageCode);
	
	DefaultMessage findByMessageCode(String messageCode);
	
}
