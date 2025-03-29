package com.stackroute.user.service;

import com.stackroute.user.model.User;

public interface UserService {
	
	public User getUser(String username);
	public boolean updateUser(User user, String username);
	public boolean addUser(User user);
	boolean deleteUser(String username);

}
