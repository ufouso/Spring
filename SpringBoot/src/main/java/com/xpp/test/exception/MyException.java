package com.xpp.test.exception;

/**
 * 自定义异常
 * @author xpp
 */
public class MyException extends RuntimeException{
	
	private static final long serialVersionUID = 3472156905278520494L;

	private String errorCode;
	
	private String errorMessage;
	
	
	public MyException(String message){
		super(message);
	}
	
	public MyException(String errorCode, String errorMessage){
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	public MyException(String errorCode, String errorMessage, Throwable cause){
		super(errorMessage, cause);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMesssage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "MyException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
}
