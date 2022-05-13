package com.dressshopapp.dao;

import com.dressshopapp.model.MenDress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MenDressRepository extends JpaRepository<MenDress,Integer> {
	
}