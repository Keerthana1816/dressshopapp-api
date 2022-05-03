package com.dressshopapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="dress_list")
public class Dress {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	
	private Integer dress_id_no;
	
	
	private String dress_name;
	
	
	private String brand_name;
	
	private String color;
	
	private String size;
	
	private Integer price;
	
}


	
	