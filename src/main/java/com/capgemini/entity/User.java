package com.capgemini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private int age;

	public User() {
	}

	public User(int userId, String userName, int age) {
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + "]";
	}

}
