package com.dangunju.payment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentResult {
    APPROVE("Approve"),
    REJECT("Reject");
	
	private String description;
}
