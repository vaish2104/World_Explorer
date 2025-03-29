package com.stackroute.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.gateway.filter.ErrorFilter;
import com.stackroute.gateway.filter.PostFilter;
import com.stackroute.gateway.filter.PreFilter;
import com.stackroute.gateway.filter.RouterFilter;

@Configuration
public class BeanConfig {
	
	@Bean
	public PreFilter preFilter()
	{
		System.out.println("Inside Pre FIlter .....");
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter()
	{
		System.out.println("Inside Post FIlter .....");
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter()
	{
		System.out.println("Inside Pre FIlter .....");
		return new ErrorFilter();
	}
	
	@Bean
	public RouterFilter routerFilter()
	{
		System.out.println("Inside Pre FIlter .....");
		return new RouterFilter();
	}

}
