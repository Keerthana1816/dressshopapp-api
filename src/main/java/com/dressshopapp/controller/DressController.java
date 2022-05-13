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

import com.dressshopapp.dao.DressRepository;
import com.dressshopapp.model.Dress;
import com.dressshopapp.service.DressService;

@RestController
public class DressController {
	@Autowired
	DressRepository dressRepository;
	
	@Autowired
	DressService dressService;

	@PostMapping("dress/save") // register details will be insert
	public ResponseEntity  <String> save(@RequestBody Dress dress){
		try {
			dressService.save(dress);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
	}

	@GetMapping("dress/list") // list all users
	public List<Dress> findAll() {
		List<Dress> dresslist = null;
		try {
			dresslist=dressService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return dresslist;
	}

	@DeleteMapping("dress/{dressid}")
	public void delete(@PathVariable("dressid") Integer dressid) {
		dressRepository.deleteById(dressid);
		

	}

	@PutMapping("dress/{id}")
	public ResponseEntity<String> update (@PathVariable("id") Integer id, @RequestBody Dress dress){
		try {
			dressService.update(id,dress);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
		}
	}

