package com.stackroute.userauthentication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.userauthentication.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String> {


	

	
}
