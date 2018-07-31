package org.rightHand.FieldAssistant.translation.service;

import java.util.List;
import java.util.Optional;

import org.rightHand.FieldAssistant.translation.model.Region;
import org.rightHand.FieldAssistant.translation.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public Region save (Region region) {
		Optional<Region> innerRegion = regionRepository.findById(region.getRegionCode());
		if(!innerRegion.isPresent()) {
			return regionRepository.saveAndFlush(region);
		}
		else return innerRegion.get();
	}
	
	public List<Region> listAll(){
		return regionRepository.findAll();
	}
	
	public Region findOne(String code) {
		return regionRepository.getOne(code);
	}
	
	public void delete(String code) {
		regionRepository.deleteById(code);
	}
	
}
