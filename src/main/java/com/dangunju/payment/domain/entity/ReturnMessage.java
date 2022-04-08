package com.dangunju.payment.domain.entity;

public class ReturnMessage {
	int returnCode;
	String returnMessage;
	
	public void setRetunCode(int code) {
		returnCode = code;
	}
	
	public int getReturnCode() {
		return returnCode;
	}
	
	public String getReturnMessage() {
		return returnMessage;
	}
	
	public void setReturnMessage(String msg) {
		returnMessage = msg;
	}
}
