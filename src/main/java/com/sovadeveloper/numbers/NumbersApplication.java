package com.sovadeveloper.numbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumbersApplication.class, args);
	}

}
