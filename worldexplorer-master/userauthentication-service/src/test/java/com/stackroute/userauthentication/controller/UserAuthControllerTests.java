package com.stackroute.userauthentication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userauthentication.model.User;
import com.stackroute.userauthentication.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserAuthControllerTests {

	 @Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private User user;
	    @MockBean
	    UserService userService;
	    @InjectMocks
	    UserAuthController userController;
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	        user = new User();
	        user.setUsername("user1@gmail.com");
	        user.setPassword("12345678");
	    }
	    
	    
	    @Test
	    public void registerUserSuccess() throws Exception  {
	        when(userService.addUser(any())).thenReturn(true);
	        mockMvc.perform(post("/api/auth/register")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
	                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
	    }
	    
	    
	    @Test
	    public void registerUserFailure() throws Exception {
	        when(userService.addUser(any())).thenReturn(false);
	        mockMvc.perform(post("/api/auth/register")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
	                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
	    }
	   
	   
	    public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
