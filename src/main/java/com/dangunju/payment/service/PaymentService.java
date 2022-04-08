package com.dangunju.payment.service;

import java.util.List;

import com.dangunju.payment.domain.entity.Payment;
import com.dangunju.payment.domain.entity.ReturnMessage;

public interface PaymentService {
	public ReturnMessage requestPayment(Payment payment);
	public List<Payment> paymentList(Payment payment);
}
