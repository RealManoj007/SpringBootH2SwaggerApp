package com.H2Crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.H2Crud.Entity.User;
import com.H2Crud.dao.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> createUser(List<User> user) {
		return userRepository.saveAll(user);
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User updateUser(User user) {
		User oldUser=null;	
		Optional<User> optionaluser=userRepository.findById(user.getId());
			
			if(optionaluser.isPresent()) {
				oldUser=optionaluser.get();
				oldUser.setName(user.getName());
				oldUser.setAddress(user.getAddress());
				userRepository.save(oldUser);
			}else {
				return new User();
			}
			return oldUser;
	}
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
	return "User deleted";	
	}

}
