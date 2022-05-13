package com.dressshopapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dressshopapp.dao.AdminRepository;
import com.dressshopapp.model.Admin;
import com.dressshopapp.validation.AdminValidation;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public void save(Admin admin) throws Exception {
		try {
			AdminValidation.validate(admin);
			adminRepository.save(admin);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Admin login(@RequestBody Admin admin)throws Exception {
		Optional<Admin> userObj = adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
		if (userObj.isPresent()) {
			return userObj.get();
		} else {
			throw new Exception("Invalid Login Credentials");
		}
	}
}