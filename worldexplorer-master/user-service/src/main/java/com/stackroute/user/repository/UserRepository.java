package com.stackroute.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
