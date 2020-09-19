package com.microservicefullProject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservicefullProject.dto.User;
import com.microservicefullProject.dto.UserToTestRestTemplate;
import com.microservicefullProject.service.UserServiceIntf;

@RestController
public class UserController {

	@Autowired
	private UserServiceIntf userI;

	@Autowired
	
	RestTemplate rest;

	private static final String URL = "http://localhost:3000/users";
	
	
	@GetMapping("/callApi")
	public void callApi() {
		getUserInfoFromThirdAPI();
	}

	public   void getUserInfoFromThirdAPI() {

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		

		HttpEntity<String> requestEntity = new HttpEntity<>(header);

		ResponseEntity<String> response = rest.exchange(URL, HttpMethod.GET, requestEntity,
				String.class);
		
		HttpStatus statusCode = response.getStatusCode();
		System.out.println("status code == >" + statusCode);
		
		 String  u = response.getBody();
		
		System.out.println("body === > " + u);
		
		HttpHeaders resHeader = response.getHeaders();
		
		System.out.println("responseHeader ---->" +resHeader);
		
		
	}

	@GetMapping("/users")
	public List<User> getAllUsr() {

		return userI.getAllUsr();
	}

	@GetMapping("/user/{id}")
	public User getUSr(@PathVariable String id) {
		return userI.getUser(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUsr(@RequestBody User u) {
		userI.addUsr(u);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(path).build();

	}

	@PutMapping("/user")

	public User updateUSr(@RequestBody User u) {

		return userI.updateUsr(u);

	}

	@DeleteMapping("/user/{id}")
	public User deleteUsr(@PathVariable String id) {
		return userI.delete(id);
	}

	@GetMapping("/sortedUser/{sortedParam}")
	public List<User> getAllSortedUser(@PathVariable String sortedParam) {
		return userI.getAllSortedUser(sortedParam);
	}

}
