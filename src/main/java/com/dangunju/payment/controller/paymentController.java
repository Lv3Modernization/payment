package com.dangunju.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dangunju.payment.domain.entity.Payment;
import com.dangunju.payment.domain.entity.ReturnMessage;
import com.dangunju.payment.service.PaymentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@EnableAspectJAutoProxy
public class paymentController {
    @Autowired
    PaymentService paymentService;
    
    @Operation(summary = "결제(취소) 요청", description = "결제(취소)를 요청한다."
    		           + "<br/>필수 입력항목: 결제구분, 판매/경매 구분, 판매/경매 게시글 번호, 판매/경매 게시글 제목, 판매자 사번, 구매자 사번, 결제 금액")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "buyer", dataType = "long", value = "구매자 사번"),
    	@ApiImplicitParam(name = "amount", dataType = "long", value = "결제 금액"),
    	@ApiImplicitParam(name = "id", dataType = "long", value = "결제ID"),
    	@ApiImplicitParam(name = "paymentGubun", dataType = "String", value = "결제구분"),
    	@ApiImplicitParam(name = "paymentResult", dataType = "String", value = "결제결과"),
    	@ApiImplicitParam(name = "postGubun", dataType = "String", value = "판매/경매 구분"),
    	@ApiImplicitParam(name = "postId", dataType = "long", value = "판매/경매 게시글 번호"),
    	@ApiImplicitParam(name = "postTitle", dataType = "String", value = "판매/경매 게시글 제목"),
    	@ApiImplicitParam(name = "seller", dataType = "long", value = "판매자 사번")
    })
    @RequestMapping(method = RequestMethod.POST, path="/payment/requestPayment")
    public ReturnMessage requestPayment(Payment payment) {
    	ReturnMessage rtnMsg = paymentService.requestPayment(payment);
    	return rtnMsg;
    }
    
    @Operation(summary = "결제(취소) 목록",
    		   description = "결제(취소)목록을 조회한다."
    		               + "<br/>Parameter가 없을 경우, 전체 목록을 가져온다."
    		               + "<br/>Parameter로 조회 가능 조합(각각 배타적으로 동작함)"
    		               + "<br/>1. 판매자"
    		               + "<br/>2. 구매자"
    		               + "<br/>3. 판매/경매 게시글 번호 및 판매/경매 게시글 제목")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "buyer", dataType = "long", value = "구매자 사번"),
    	@ApiImplicitParam(name = "amount", dataType = "long", value = "결제 금액"),
    	@ApiImplicitParam(name = "id", dataType = "long", value = "결제ID"),
    	@ApiImplicitParam(name = "paymentGubun", dataType = "String", value = "결제구분"),
    	@ApiImplicitParam(name = "paymentResult", dataType = "String", value = "결제결과"),
    	@ApiImplicitParam(name = "postGubun", dataType = "String", value = "판매/경매 구분"),
    	@ApiImplicitParam(name = "postId", dataType = "long", value = "판매/경매 게시글 번호"),
    	@ApiImplicitParam(name = "postTitle", dataType = "String", value = "판매/경매 게시글 제목"),
    	@ApiImplicitParam(name = "seller", dataType = "long", value = "판매자 사번")
    })
    @RequestMapping(method = RequestMethod.POST, path="/payment/requestPaymentList")
    public List<Payment> paymentList(Payment payment) {
    	List<Payment> paymentList = paymentService.paymentList(payment);
    	return paymentList;
    }
}
