package com.example.amit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
