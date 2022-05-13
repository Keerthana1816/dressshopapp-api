package com.dressshopapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dressshopapp.dao.MenDressRepository;
import com.dressshopapp.model.MenDress;
import com.dressshopapp.validation.MenDressValidation;

@Service
public class MenDressService {

	@Autowired
	MenDressRepository mendressRepository;
	
	public void save( MenDress mendress) throws Exception {
		try { 
			MenDressValidation.validateDress(mendress);
			mendressRepository.save(mendress);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<MenDress> findAll() throws Exception {
		List<MenDress> menlistdress=null;
		try {
			menlistdress=mendressRepository.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return menlistdress;
	}

	public void update(@PathVariable("id") Integer id, @RequestBody MenDress mendress)throws Exception{
		try {
			mendress.setId(id);
			MenDressValidation.validateDress(mendress);
			mendressRepository.save(mendress);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
