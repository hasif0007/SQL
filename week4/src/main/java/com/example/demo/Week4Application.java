package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week4Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Week4Application.class, args);
        
        // Use the context to remove the yellow "unused" warning
        System.out.println("IoC Container Loaded: " + context.getDisplayName());
        System.out.println("Week 4 System Started on Port 8081");
    }
}