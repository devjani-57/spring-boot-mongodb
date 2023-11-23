package com.sample.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.springbootmongodb.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
