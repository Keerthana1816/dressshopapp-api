package com.dressshopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dressshopapp.dao.AdminRepository;
import com.dressshopapp.model.Admin;
import com.dressshopapp.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminRepository adminRepository;

	@Autowired
	AdminService adminService;

	@PostMapping("admin/save") // register details will be insert
	public ResponseEntity<String> save(@RequestBody Admin admin) {
		try {
			adminService.save(admin);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("admin/login")
	public String login(@RequestBody Admin admin) {
		return adminService.login(admin);

	}
}