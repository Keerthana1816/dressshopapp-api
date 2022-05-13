package com.dressshopapp.model;

import javax.persistence.Column;
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
	
	@Column(name = "dress_id_no")
	private Integer id;
	
	@Column(name = "dress_name")
	private String dressName;
	
	@Column(name="brand_name")
	private String brandName;
	
	private String color;
	
	private String size;
	
	private Integer price;

	@Column(name="image_url")
	private String imageUrl;

	
	}
	



	
	