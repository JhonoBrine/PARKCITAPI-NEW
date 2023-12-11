package com.cit.parkcit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cit.parkcit")
public class ParkcitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkcitApplication.class, args);
	}

}
