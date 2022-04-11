package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByAge(int age);

}
