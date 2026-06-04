package com.project.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessMonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessMonolithApplication.class, args);
		System.out.println(System.getenv("DB_URL"));
		System.out.println(System.getenv("DB_USER"));
		System.out.println(System.getenv("DB_PWD"));
	}

}
