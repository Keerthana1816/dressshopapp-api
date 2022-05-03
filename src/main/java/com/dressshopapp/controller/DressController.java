package com.dressshopapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dressshopapp.dao.DressRepository;
import com.dressshopapp.model.Dress;

@RestController
public class DressController {
	@Autowired
	DressRepository dressRepository;

	@PostMapping("dress/insert") // dress details will be insert
	public Dress save(@RequestBody Dress dress) {
		dressRepository.save(dress);
		return dress;

	}

	@GetMapping("/dresslist") // list all employees
	public List<Dress> findAll() {
		List<Dress> dresslist = dressRepository.findAll();
		return dresslist;
	}

	@DeleteMapping("dress/{dressid}")
	public void delete(@PathVariable("dressid") Integer dressid) {
		dressRepository.deleteById(dressid);

	}

	@PutMapping("dress/{dressname}")
	public void update(@PathVariable("dressname") String dressid) {
		Dress dress = new Dress();
		dress.setDress_name(dressid);
		dressRepository.save(dress);
	}
}
