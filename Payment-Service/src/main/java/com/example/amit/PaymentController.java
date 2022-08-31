package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/create/payment")
	public Payment createPayment(@RequestBody Payment payment)
	{
		 return this.paymentService.createPayment(payment);
	}
	
}
