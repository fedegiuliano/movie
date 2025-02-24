package com.example.movies;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
}
