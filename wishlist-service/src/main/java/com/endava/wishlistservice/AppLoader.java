package com.endava.wishlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppLoader extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AppLoader.class, args);
	}
}
