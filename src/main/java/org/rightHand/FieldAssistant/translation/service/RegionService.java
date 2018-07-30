package org.rightHand.FieldAssistant.translation.service;

import java.util.List;

import org.rightHand.FieldAssistant.translation.model.Region;
import org.rightHand.FieldAssistant.translation.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public Region save (Region region) {
		if(!regionRepository.existsByRegionCode(region.getRegionCode())) {
			return regionRepository.saveAndFlush(region);
		}
		else return null;
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
