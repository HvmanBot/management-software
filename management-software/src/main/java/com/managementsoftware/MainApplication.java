package com.managementsoftware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * The @SpringBootApplication annotation enables auto-configuration
 * and component scanning in this package and its subpackages.
 */
@SpringBootApplication
public class MainApplication {

    /**
     * The main method triggers Spring Boot's auto-configuration
     * and starts the embedded server (e.g., Tomcat by default).
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}