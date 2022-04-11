package com.capgemini.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserBo {
	
	private int userId;
	
	@NotNull(message = "User Name should not be empty...")
	@NotEmpty(message = "User Name should not be empty...")
	private String userName;
	
	@Min(value = 18,message = "Age vlue should not be less than 18 years")
	@Max(value = 99, message = "Age value should not be grater than 99 years")
	private int age;

	public UserBo() {
	}

	public UserBo(int userId, String userName, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
