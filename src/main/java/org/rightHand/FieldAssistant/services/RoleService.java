package org.rightHand.FieldAssistant.services;

import java.util.List;

import org.rightHand.FieldAssistant.model.Role;
import org.rightHand.FieldAssistant.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	public Role save (Role role) {
		if(!roleRepository.existsByName(role.getName())) {
			return roleRepository.saveAndFlush(role);
		}
		else return null;
	}
	
	public List<Role> listAll(){
		return roleRepository.findAll();
	}
	
	public Role findOne(Long id) {
		return roleRepository.getOne(id);
	}
	
	public void delete(Long id) {
		roleRepository.deleteById(id);
	}
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
	
	
}
