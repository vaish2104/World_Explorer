package com.stackroute.userauthentication.model;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserTests {

private User user;
	
	@Before
	public void setUp() {
		user = new User();
        user.setUsername("shivansh");
        user.setPassword("password");
	}
		
        @Test
    	public void test() {
    		new BeanTester().testBean(User.class);
    	}
}
