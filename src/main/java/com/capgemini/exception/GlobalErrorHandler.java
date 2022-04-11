package com.capgemini.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalErrorHandler {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseError handleControllerException(ConstraintViolationException ex) {
		ResponseError responseError = new ResponseError();
		List<String> errorMsgs = new ArrayList<>();
		for(ConstraintViolation constraint:ex.getConstraintViolations()) {
			errorMsgs.add(constraint.getPropertyPath()+"  :  "+constraint.getMessage());
		}
		responseError.setErrorMessage(errorMsgs);
		responseError.setStatusCode(HttpStatus.BAD_REQUEST);
		
		return responseError;
		
	}

}
