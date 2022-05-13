package com.dressshopapp.validation;

import com.dressshopapp.model.MenDress;

public class MenDressValidation {

	public static void validateDress(MenDress dress) throws Exception {
		if (dress.getDressName() != null) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (dress.getBrandName() != null) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (dress.getSize() != null) {
		} else {
			throw new Exception("The size cannot be empty");
		}
		if (dress.getPrice() != null) {
		} else {
			throw new Exception("The price cannot be empty");
		}
		System.out.println("You have added dress");

	}
}
