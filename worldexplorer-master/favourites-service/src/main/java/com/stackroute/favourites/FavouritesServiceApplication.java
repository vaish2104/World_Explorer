package com.stackroute.favourites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.stackroute.userauthentication.config.JWTFilter;

//configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning
//Spring boot application for the purpose of handling the favourites section
@EnableEurekaClient
@SpringBootApplication
public class FavouritesServiceApplication {

	// Bean of JWT token for validating the JWT provided in header
//		@Bean
//		public FilterRegistrationBean jwtFilter() {
//			
//			FilterRegistrationBean registrationbean = new FilterRegistrationBean();
//			registrationbean.setFilter(new JWTFilter());
//			registrationbean.addUrlPatterns("/api/*");
//			return registrationbean;
//			
//		}

	public static void main(String[] args) {
		SpringApplication.run(FavouritesServiceApplication.class, args);
	}

}
