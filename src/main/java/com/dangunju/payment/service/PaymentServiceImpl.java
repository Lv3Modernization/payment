package com.dangunju.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangunju.payment.domain.entity.Payment;
import com.dangunju.payment.domain.entity.PaymentGubun;
import com.dangunju.payment.domain.entity.ReturnMessage;
import com.dangunju.payment.domain.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    
    @Override
    public ReturnMessage requestPayment(Payment payment) {
    	ReturnMessage rtn = null;
    	
    	// 성공을 기본값으로 설정
    	rtn.setRetunCode(0);
    	rtn.setReturnMessage("Succeed");
    	
    	// Input Validation
    	if (payment.getPaymentGubun() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("결제구분(paymentGubun에 REQUEST_PAYMENT 혹은 CANCEL_PAYMENT를 입력하여 주세요.");
    	}
    	if (payment.getSeller() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("판매자 정보를 입력하여 주세요.");
    	}
    	if (payment.getBuyer() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("구매자 정보를 입력하여 주세요.");
    	}
    	if (payment.getPostGubun() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("판매 혹은 경매 구분을 입력하여 주세요.");
    	}
    	if (payment.getPostId() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("판매 혹은 경매 게시글 번호를 입력하여 주세요.");
    	}
    	if (payment.getPostTitle() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("판매 혹은 경매 게시글 제목을 입력하여 주세요.");
    	}
    	if (payment.getAmount() == null) {
    		rtn.setRetunCode(1);
    		rtn.setReturnMessage("판매 혹은 경매 금액을 입력하여 주세요.");
    	}
    	
    	//SV시스템에 결제(취소) 요청
    	//SV시스템과 연계가 되었다고 가정하고 임의의 값을 반환받는 로직으로 대체합니다.
        rtn.setRetunCode(getSVPaymentResult(payment));
        if (rtn.getReturnCode() == 0 && payment.getPostGubun().equals(PaymentGubun.REQUEST_PAYMENT)) rtn.setReturnMessage("결제요청이 성공하였습니다.");
        else if (rtn.getReturnCode() == 0 && payment.getPostGubun().equals(PaymentGubun.CANCEL_PAYMENT)) rtn.setReturnMessage("결제취소요청이 성공하였습니다.");
        else if (rtn.getReturnCode() == 1 && payment.getPostGubun().equals(PaymentGubun.REQUEST_PAYMENT)) rtn.setReturnMessage("결제요청이 실패하였습니다.");
        else if (rtn.getReturnCode() == 1 && payment.getPostGubun().equals(PaymentGubun.CANCEL_PAYMENT)) rtn.setReturnMessage("결제취소요청이 실패하였습니다.");
        
    	//결제(취소)요청 이력 저장
    	paymentRepository.save(payment);
    	
    	return rtn;
    }
    
    @Override
    public List<Payment> paymentList(Payment payment) {
    	List<Payment> paymentList;
    	if (payment.getSeller() != null) paymentList = paymentRepository.findBySeller(payment.getSeller());
    	else if (payment.getBuyer() != null) paymentList = paymentRepository.findByBuyer(payment.getBuyer());
    	else if (payment.getPostGubun() != null && payment.getPostId() != null) paymentList = paymentRepository.findByPostGubunAndPostId(payment.getPostGubun(), payment.getPostId());
    	else paymentList = paymentRepository.findAll();
    	return paymentList;
    }
    
    //SV시스템과 연계가 되었다고 가정하고 임의의 값을 반환받는 로직으로 대체합니다.
    private int getSVPaymentResult(Payment payment) {
    	int rtnCode = (int)(Math.random() * 50 + 1) % 2;
    	return rtnCode;
    }
}
