package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	public TransactionResponse createOrder(TransactionRequest request) {

		String message="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();

		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		// rest call
		
		Payment  paymentResponse =
				restTemplate.postForObject("http://localhost:5252/create/payment", payment, Payment.class);
		
		message=paymentResponse.getPaymentStatus().equals("Success")?"Payment success and Order Placed":"Failure in payment API, added to cart";

		this.orderRepository.save(order);
		
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),message);
	}
}
