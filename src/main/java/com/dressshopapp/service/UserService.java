package com.dressshopapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dressshopapp.dao.UserRepository;
import com.dressshopapp.model.User;
import com.dressshopapp.validation.UserValidation;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void save( User user) throws Exception {
		try { 
			UserValidation.validateUser(user);
			userRepository.save(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public User login( User user) throws Exception {
		Optional<User> userObj=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
			throw new Exception("Invalid Login Credentials");
		}
}
	public List<User> findAll() throws Exception {
		List<User> listUser=null;
		try {
			listUser=userRepository.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return listUser;
	}

	public void update(@PathVariable("id") Integer id, @RequestBody User user)throws Exception{
		try {
			user.setId(id);
			UserValidation.validateUser(user);
			userRepository.save(user);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}

			
		
