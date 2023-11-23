package com.sample.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springbootmongodb.model.User;
import com.sample.springbootmongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	private UserRepository repository; //save, findById, findAll, update, delete
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	public Optional<User> findUserById(int id){
		return repository.findById(id);
	}
	public User createUser(User user) {
		return repository.save(user);
	}
	public void deleteUser(int id) {
		 repository.deleteById(id);
	}
	public User updateUser(int id,User newUser) {
		newUser.setId(id);
		return repository.save(newUser);
	}
	
}
