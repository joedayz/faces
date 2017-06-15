package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.mycompany.model.Order;

public class OrderService {

	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(String name, String email, 
			String drink, String comments){
		Order order = new Order(name, email, drink,
				comments);
		orders.add(order);
	}
	
	@PostConstruct
	public void create(){
		orders = new ArrayList<Order>();
	}

}
