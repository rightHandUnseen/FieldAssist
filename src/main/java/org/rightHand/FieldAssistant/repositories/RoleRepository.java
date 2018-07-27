package org.rightHand.FieldAssistant.repositories;

import org.rightHand.FieldAssistant.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	boolean existsByName(String name);
	
	Role findByName(String name);
	
}
