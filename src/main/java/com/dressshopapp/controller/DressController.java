package com.dressshopapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("dress/dresslist") // list all employees
	public List<Dress> findAll() {
		List<Dress> dresslist = dressRepository.findAll();
		return dresslist;
	}

	@DeleteMapping("dress/{dressid}")
	public void delete(@PathVariable("dressid") Integer dressid) {
		dressRepository.deleteById(dressid);

	}
	@GetMapping("dress/finddress/{id}")
	public Dress findById(@PathVariable("id") Integer id) {
		Optional<Dress> dress =dressRepository.findById(id);
		if (dress.isPresent()) {
			return dress.get();
		} else {
			return null;
		}
	}
	@GetMapping("dress/finddress/color")
	public Dress findByColor(@PathVariable("color") String  color) {
		Optional<Dress> dress =dressRepository.findByColor("color");
		if (dress.isPresent()) {
			return dress.get();
		} else {
			return null;
		}

	}
	@PutMapping("dress/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody Dress dress) {

		dress.setId(id);
		dressRepository.save(dress);
	}
}
