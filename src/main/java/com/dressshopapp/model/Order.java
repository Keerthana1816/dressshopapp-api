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
@Entity(name="order_list")
public class Order {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	
	@Column(name = "order_id")
	private Integer id;
	
	@Column(name="dress_id_no")
	private Integer dressid;
	
	private Integer price;
	
	private Integer quantity;
	
	@Column(name="total_price")
	private Integer totalprice;
	
}

