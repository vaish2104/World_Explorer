package com.stackroute.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.stackroute.userauthentication.config.JWTFilter;

@EnableEurekaClient
@SpringBootApplication
public class UserApplication {
	
	
	// Bean of JWT token for validating the JWT provided in header
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JWTFilter());
		registrationbean.addUrlPatterns("/api/user/pro/*");
		return registrationbean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
