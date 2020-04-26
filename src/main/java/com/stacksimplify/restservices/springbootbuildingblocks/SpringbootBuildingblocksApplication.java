package com.stacksimplify.restservices.springbootbuildingblocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication @ComponentScan(basePackages = { "com.stacksimplify.restservices.hello",
		"com.stacksimplify.restservices.services", "com.stacksimplify.restservices.controllers"} )
@EnableJpaRepositories(basePackages = "com.stacksimplify.restservices.repositories")
@EntityScan( basePackages = {"com.stacksimplify.restservices.entities"} )
public class SpringbootBuildingblocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBuildingblocksApplication.class, args);
	}

}
