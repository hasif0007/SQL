package com.example.demo;

import org.springframework.stereotype.Component;

@Component("emailNotify")
public class EmailNotificationService implements NotificationService {
    
    @Override // Add this to check for errors
    public String send(String message) { 
        return "Email sent to: " + message; 
    }
}