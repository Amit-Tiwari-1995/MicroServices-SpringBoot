package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	public Order createOrder(Order order)
	{
		 return this.orderRepository.save(order);
	}
}
