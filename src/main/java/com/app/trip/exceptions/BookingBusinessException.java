package com.app.trip.exceptions;

public class BookingBusinessException extends Exception{

	public BookingBusinessException() {
		
	}
	public BookingBusinessException(String msg, String errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}
	
	private String msg;
	
	private String errorCode;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "BookingBusinessException [msg=" + msg + ", errorCode=" + errorCode + "]";
	}
	
}
