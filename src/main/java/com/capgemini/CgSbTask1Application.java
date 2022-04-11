package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CgSbTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(CgSbTask1Application.class, args);
	}

}
