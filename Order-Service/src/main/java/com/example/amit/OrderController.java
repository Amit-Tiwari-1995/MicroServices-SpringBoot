
package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/create/order")
	public Order createOrder(@RequestBody Order order)
	{
		 return this.orderService.createOrder(order);
	}
	
}
