package com.dressshopapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dressshopapp.dao.DressRepository;
import com.dressshopapp.model.Dress;
import com.dressshopapp.validation.DressValidation;

@Service
public class DressService {

	@Autowired
	DressRepository dressRepository;
	
	public void save( Dress dress) throws Exception {
		try { 
			DressValidation.validateDress(dress);
			dressRepository.save(dress);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Dress> findAll() throws Exception {
		List<Dress> listDress=null;
		try {
			listDress=dressRepository.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return listDress;
	}

	public void update(@PathVariable("id") Integer id, @RequestBody Dress dress)throws Exception{
		try {
			dress.setId(id);
			DressValidation.validateDress(dress);
			dressRepository.save(dress);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
