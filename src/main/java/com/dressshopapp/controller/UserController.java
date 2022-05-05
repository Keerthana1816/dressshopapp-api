package com.dressshopapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dressshopapp.dao.UserRepository;
import com.dressshopapp.model.User;
import com.dressshopapp.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@PostMapping("user/save") // register details will be insert
	public ResponseEntity  <String> save(@RequestBody User user){
		try {
			userService.save(user);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
	}
	
	@PostMapping("user/login")
	public String login(@RequestBody User user) {
		return userService.login(user);

		
	}

	@GetMapping("user/list") // list all users
	public List<User> findAll() {
		List<User> userlist = null;
		try {
			userlist=userService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return userlist;
	}

	@DeleteMapping("user/{userid}")
	public void delete(@PathVariable("userid") Integer userid) {
		userRepository.deleteById(userid);
		

	}

	@PutMapping("user/{id}")
	public ResponseEntity<String> update (@PathVariable("id") Integer id, @RequestBody User user){
		try {
			userService.save(user);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
		}
	}

