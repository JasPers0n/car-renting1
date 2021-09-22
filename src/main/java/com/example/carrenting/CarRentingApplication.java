package com.example.carrenting;

import com.example.carrenting.entity.Employee;
import com.example.carrenting.entity.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.carrenting.entity.Position.MANAGER;

@SpringBootApplication
public class CarRentingApplication {


	public static void main(String[] args) {
		SpringApplication.run(CarRentingApplication.class, args);
	}
}
