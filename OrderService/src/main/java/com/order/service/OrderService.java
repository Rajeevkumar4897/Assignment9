package com.order.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	public Order saveOrder(Order order) {
		return repo.save(order);
	}

	public Order getOrderById(Integer orderId) {
		Optional<Order> order1 = repo.findById(orderId);
		Order order2 = null;
		if(order1.isPresent()) {
			order2 = order1.get();
		}
		return order2;
	}

	public List<Order> getOrdersByPincode(int pincode) {
		
		List<Order> orderList = repo.findAll();
		List<Order> orderProducts = new ArrayList<>();
		for(Order or:orderList) {
			if(or.getAddress().getPin()==pincode) {
				orderProducts.add(or);
			}
		}
		
		return orderProducts;
	}
	
	
	
}
