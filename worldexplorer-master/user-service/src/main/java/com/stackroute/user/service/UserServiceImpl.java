package com.stackroute.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.user.model.User;
import com.stackroute.user.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	//Here we are using Autowired inorder to acess method's provided by mongod reposistory.
	@Autowired
	private UserRepository userRepository;
	
	//By using get user method with the help of username we are getting entire userdetails based on username.
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.findById(username).get();
	}
	
	//By using this method update method with help of username we can identify the user and details are updated with user details.
	@Override
	public boolean updateUser(User user, String username) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteById(username);
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//This method is used to add a new user who doesn't exists in database.
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			if (!userRepository.existsById(user.getUsername())) {
				userRepository.insert(user);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		try {
			if (userRepository.existsById(username)) {
				userRepository.deleteById(username);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

}
