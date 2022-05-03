package com.dressshopapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dressshopapp.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

	void save(Integer dress_id_no);



	

	

}
