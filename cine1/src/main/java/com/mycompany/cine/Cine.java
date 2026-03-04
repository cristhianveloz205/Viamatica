package com.mycompany.cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mycompany.cine") 
@EntityScan(basePackages = "com.mycompany.cine.model") 
@EnableJpaRepositories(basePackages = "com.mycompany.cine.repository") 
public class Cine {
    public static void main(String[] args) {
        SpringApplication.run(Cine.class, args);
    }
}
