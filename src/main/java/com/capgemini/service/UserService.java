package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.User;
import com.capgemini.entity.UserBo;

public interface UserService {
	
	public String saveUser(UserBo userBo);

	public List<User> getAllUsers();
	
	public List<User> getUsersByAge(int age);
	
}
