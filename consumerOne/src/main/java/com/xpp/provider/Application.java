package com.xpp.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource
public class Application{
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}