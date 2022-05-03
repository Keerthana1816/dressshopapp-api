package com.dressshopapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dressshopapp.model.Dress;

@Repository
public interface DressRepository extends JpaRepository<Dress,Integer> {



	

	

}
