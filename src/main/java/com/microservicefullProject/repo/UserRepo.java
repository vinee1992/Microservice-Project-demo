package com.microservicefullProject.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.microservicefullProject.dto.User;

@Repository
public class UserRepo {

	List<User> usrList = new ArrayList<User>();

	public List<User> getAllUsr() {
		// TODO Auto-generated method stub
		return usrList;
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		Optional<User> usr = usrList.stream().filter(u -> u.getId().equals(id)).findFirst();
		if (usr.isPresent())
			return usr.get();
		return new User();

	}

	public void addUsr(User u) {
		// TODO Auto-generated method stub
		
		usrList.add(u);

	}

	public User updateUsr(User u) {
		// TODO Auto-generated method stub
		
		for(User us : usrList) {
			
			if(us.getId().equals(u.getId()))
			{
				us.setName(u.getName());
				us.setAddress(u.getAddress());
				return us;
			}
		}
		return new User();
	}

	public User delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
