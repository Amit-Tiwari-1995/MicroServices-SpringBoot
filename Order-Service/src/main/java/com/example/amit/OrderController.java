
package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create/order")
	public TransactionResponse createOrder(@RequestBody TransactionRequest request) {

		return this.orderService.createOrder(request);
	}

}
