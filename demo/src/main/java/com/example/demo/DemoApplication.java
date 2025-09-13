package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	int age = 24;

	// method
	public int sum() {
		return this.age + 10;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		DemoApplication obj = new DemoApplication();
		System.out.println(obj.sum());
	}

}
