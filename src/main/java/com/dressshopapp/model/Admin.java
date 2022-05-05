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
@Entity(name = "dress_app_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement
	private Integer id;

	private String name;

	private String email;

	private String password;

}