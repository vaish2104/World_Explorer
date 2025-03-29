package com.stackroute.user.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.user.model.User;
import com.stackroute.user.repository.UserRepository;

public class UserServiceImpl {
	
	@Mock
    UserRepository userRepository;
	
	User user;
	
	@InjectMocks
   UserServiceImpl userService;
	
	@Before
	public void setUp() {
       MockitoAnnotations.initMocks(this);
       user = new User();
       user.setUsername("shivaagn@123");
       user.setMobile("9810316274");
       
       user.setName("Shivansh");
	}
	@Test
   public void addUserSuccess(){
       when(userRepository.save((User) any())).thenReturn(user);
       User userSaved = userRepository.save(user);
       assertEquals(user, userSaved);
   }

}
