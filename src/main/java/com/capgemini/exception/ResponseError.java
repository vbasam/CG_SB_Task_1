package com.capgemini.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseError {
	
	private List<String> errorMessage;
	private HttpStatus statusCode;
	
	public List<String> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus badRequest) {
		this.statusCode = badRequest;
	}
	
	
}
