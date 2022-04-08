package com.dangunju.payment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentGubun {
    REQUEST_PAYMENT("결제요청"),
    CANCEL_PAYMENT("결제취소요청");
	
	private String description;
}
