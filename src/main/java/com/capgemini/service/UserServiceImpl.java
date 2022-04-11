package com.capgemini.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.UserRepository;
import com.capgemini.entity.User;
import com.capgemini.entity.UserBo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public String saveUser(UserBo userBo) {
		validateEntity(userBo);
		User user= new User();
		user.setAge(userBo.getAge());
		user.setUserId(userBo.getUserId());
		user.setUserName(userBo.getUserName());
		User userObj = repository.save(user);
		if (userObj != null) {
			return "User saved...";
		} else {
			return "Failed while saving the user..";
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = repository.findAll();
		if (!usersList.isEmpty()) {
			return usersList;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public List<User> getUsersByAge(int age) {
		List<User> usersList = repository.findByAge(age);
		if (!usersList.isEmpty()) {
			return usersList;
		} else {
			return Collections.emptyList();
		}
	}
	private void validateEntity(UserBo userBo) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<UserBo>> constraintViolations = validator.validate(userBo);

		for (ConstraintViolation<UserBo> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}
}
