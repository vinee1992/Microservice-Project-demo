package com.microservicefullProject.service;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;

import com.microservicefullProject.dto.User;

public interface UserServiceIntf {

	List<User> getAllUsr();

	User getUser(String id);

	void addUsr(User u);

	User updateUsr(User u);

	User delete(String id);

	@Lock(LockModeType.NONE)
	List<User>  getAllSortedUser(String sortedParam);

}