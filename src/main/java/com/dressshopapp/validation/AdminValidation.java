package com.dressshopapp.validation;

import com.dressshopapp.model.Admin;

public class AdminValidation {

	public static void validate(Admin admin) throws Exception {
		if (admin.getName() != null && !admin.getName().trim().equals("")) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (admin.getEmail().contains("@") && admin.getEmail().contains(".com")) {
		} else {
			throw new Exception("Enter a valid email ID");
		}
		if (admin.getPassword().length() > 8) {
		} else {
			throw new Exception("Enter a strong password");
		}

		System.out.println("You have registerd successfully");

	}
}