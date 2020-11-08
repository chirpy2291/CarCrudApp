package com.sneha.carcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sneha*"})
@EntityScan("com.sneha*")
@EnableJpaRepositories("com.sneha*")
public class CarCrud {

	public static void main(String[] args) {
		SpringApplication.run(CarCrud.class, args);
	}

}
