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

import com.dressshopapp.dao.MenDressRepository;
import com.dressshopapp.model.MenDress;
import com.dressshopapp.service.MenDressService;

@RestController
public class MenDressController {
	@Autowired
	MenDressRepository mendressRepository;
	
	@Autowired
	MenDressService mendressService;

	@PostMapping("mendress/save") // dress details will be insert
	public ResponseEntity  <String> save(@RequestBody MenDress mendress){
		try {
			mendressService.save(mendress);
			return new ResponseEntity<String> (HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
	}

	@GetMapping("mendress/list") // list all dresses
	public List<MenDress> findAll() {
		List<MenDress> mendresslist = null;
		try {
			mendresslist=mendressService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return mendresslist;
	}

	@DeleteMapping("mendress/{id}")
	public void delete(@PathVariable("id") Integer id) {
		mendressRepository.deleteById(id);
		

	}

	@PutMapping("mendress/{id}")
	public ResponseEntity<String> update (@PathVariable("id") Integer id, @RequestBody MenDress mendress){
		try {
			mendressService.update(id,mendress);
			return new ResponseEntity<String> (HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
		}
	}

