package org.rightHand.FieldAssistant.translation.repository;

import org.rightHand.FieldAssistant.translation.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, String>{

	boolean existsByRegionCode(String regionCode);
	
}
