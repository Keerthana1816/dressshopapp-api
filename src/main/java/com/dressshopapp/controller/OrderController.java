package com.dressshopapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dressshopapp.dao.OrderRepository;
import com.dressshopapp.model.Order;

@RestController
public class OrderController {
	@Autowired
	OrderRepository orderRepository;

	@PostMapping("order/insert") // order details will be insert
	public Order save(@RequestBody Order order) {
		orderRepository.save(order);
		return order;

	}

	@GetMapping("/orderlist") // list all employees
	public List<Order> findAll() {
		List<Order> orderlist = orderRepository.findAll();
		return orderlist;
	}

	@DeleteMapping("order/{orderid}")
	public void delete(@PathVariable("orderid") Integer orderid) {
		orderRepository.deleteById(orderid);

	}

	@PutMapping("order/{dress_id_no}")
	public void update(@PathVariable("dress_id_no") Integer dress_id_no) {
		Order order = new Order();
		order.setDress_id_no(dress_id_no);
		orderRepository.save(dress_id_no);
	}
}
