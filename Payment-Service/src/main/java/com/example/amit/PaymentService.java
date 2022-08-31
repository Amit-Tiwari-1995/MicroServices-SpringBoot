package com.example.amit;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment createPayment(Payment payment)

	{
		payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
		return this.paymentRepository.save(payment);
	}
	
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"Success":"False";
	}


	public Payment getPaymentHistoryById(int id) {
		
		return this.paymentRepository.findPaymentByOrderId(id);
	}
}
