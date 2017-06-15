package com.mycompany.web;

import java.util.List;

import com.mycompany.model.Order;
import com.mycompany.service.OrderService;

public class BarBean {

	private OrderService orderService;
	
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	public int getRowCount(){
		return orderService.getOrders().size();
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	
}
