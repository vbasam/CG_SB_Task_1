package com.capgemini.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.User;
import com.capgemini.entity.UserBo;
import com.capgemini.exception.ResponseError;
import com.capgemini.service.UserService;

@RestController
public class UserRestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private UserService service;

	@PostMapping(value = "/saveUser", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> saveUser(@RequestBody UserBo user) {
		try {
			String result = service.saveUser(user);
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		}catch(ConstraintViolationException ex) {
			logger.warn(ex.getMessage());
			ResponseError controllerException = handleControllerException(ex);
			return new ResponseEntity<Object>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return "Welcome....";
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = service.getAllUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception ex) {
			logger.warn(ex.getMessage());
		}
		return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getUsersByAge/{age}")
	public ResponseEntity<List<User>> getUsersByAge(@PathVariable int age) {
		try {
			List<User> list = service.getUsersByAge(age);

			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			logger.warn(ex.getMessage());
		}
		return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
	}
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	private ResponseError handleControllerException(ConstraintViolationException ex) {
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
