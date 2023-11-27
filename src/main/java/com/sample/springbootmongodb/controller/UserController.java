package com.sample.springbootmongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springbootmongodb.model.User;
import com.sample.springbootmongodb.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/findall")
	public List<User> getAllUsers(){
		return service.findAllUsers();
		
	}
	@GetMapping("get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		Optional<User> user=service.findUserById(id);
		return user.map(value ->new ResponseEntity<>(value,HttpStatus.OK))
				.orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping("/create")
	public ResponseEntity<User> nwUser(@RequestBody User user){
		User createdUser=service.createUser(user);
		return new  ResponseEntity<>(createdUser,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user) {
		User updatedUser=service.updateUser(id, user);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
	 service.deleteUser(id);
	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
