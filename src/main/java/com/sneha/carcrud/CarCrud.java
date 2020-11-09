package com.sneha.carcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//Following annotations as segregating layers were not getting identified
@ComponentScan({"com.sneha*"})
@EntityScan("com.sneha*")
@EnableJpaRepositories("com.sneha*")
//For hystrix
@EnableHystrix
@EnableCircuitBreaker
//For caching
@EnableCaching
public class CarCrud {


	public static void main(String[] args) {
		SpringApplication.run(CarCrud.class, args);
	}

//Attempt to resolve junits for entityManager
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//	    return sessionFactory;
//	}

}
