package org.rightHand.FieldAssistant.services;

import java.util.List;

import org.rightHand.FieldAssistant.model.User;
import org.rightHand.FieldAssistant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User save (User user) {
		User innerUser = findByUsername(user.getUsername());
		if(innerUser==null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			return userRepository.saveAndFlush(user);
		}
		else return innerUser;
	}
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public User findOne(Long id) {
		return userRepository.getOne(id);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
