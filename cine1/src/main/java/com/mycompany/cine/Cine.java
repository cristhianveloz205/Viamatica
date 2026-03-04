package com.mycompany.cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mycompany.cine") // Busca los Controladores y Servicios
@EntityScan(basePackages = "com.mycompany.cine.model") // Busca las tablas de la BD
@EnableJpaRepositories(basePackages = "com.mycompany.cine.repository") // Busca las consultas SQL
public class Cine {
    public static void main(String[] args) {
        SpringApplication.run(Cine.class, args);
    }
}