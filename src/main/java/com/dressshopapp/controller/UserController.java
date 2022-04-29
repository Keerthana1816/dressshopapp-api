package com.dressshopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dressshopapp.dao.UserRepository;
import com.dressshopapp.model.User;

@RestController
	public class UserController {
		
		@Autowired
		UserRepository userRepository;
		
		
	
		@PostMapping("user/save")//register details will be insert
		public User save(@RequestBody User user) {
			userRepository.save(user);
			return user;
		}

		
//		@GetMapping("users/list")//list all employees
//		public List<User>findAll(){
//			List<User>userlist=userRepository.findAll();
//			return userlist;
//		}
		@DeleteMapping("user/{userId}")
		public void delete(@PathVariable("userId") Integer userId)
		{
			userRepository.deleteById(userId);
		
		}
		
	@PutMapping("user/{username}")
	public void update(@PathVariable("username") String userId)
	{
		User user = new User();
	     user.setName(userId);
	userRepository.save(user);
	}
	
}
	


