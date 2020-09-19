package com.microservicefullProject.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.microservicefullProject.dto.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>  {
	
	
	
	
}
