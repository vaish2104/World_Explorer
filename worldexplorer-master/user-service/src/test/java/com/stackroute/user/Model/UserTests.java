package com.stackroute.user.Model;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.stackroute.user.model.User;

public class UserTests {

	
	private User user;

	@Before
	public void setUp() {
		user = new User();

		user.setUsername("shivaagn@123");
		user.setMobile("9810316274");
		
		user.setName("Shivansh");
	}

	@Test
	public void test() {
		new BeanTester().testBean(User.class);
	}
	
}
