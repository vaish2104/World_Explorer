package com.stackroute.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekaWexplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaWexplorerApplication.class, args);
	}

}
