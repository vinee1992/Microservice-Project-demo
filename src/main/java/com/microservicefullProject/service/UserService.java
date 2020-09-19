package com.microservicefullProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservicefullProject.dto.User;
import com.microservicefullProject.repo.UserRepository;

@Service
public class UserService implements UserServiceIntf {

	@Autowired
	private UserRepository repo;

	public List<User> getAllUsr() {
		// TODO Auto-generated method stub
		return (List<User>) repo.findAll();
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void addUsr(User u) {
		// TODO Auto-generated method stub

		repo.save(u);

	}

	public User updateUsr(User u) {
		// TODO Auto-generated method stub
		User user = repo.findById(u.getId()).get();
		user.setId(u.getId());
		user.setName(u.getName());
		user.setAddress(u.getAddress());
		return user;
	}

	public User delete(String id) {

		return null;
	}

	@Override
	public List<User>  getAllSortedUser(String sortedParam) {
		// TODO Auto-generated method stub
		return (List<User>) repo.findAll(Sort.by(sortedParam));
	}

}
