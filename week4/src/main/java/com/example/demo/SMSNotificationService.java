package com.example.demo;
import org.springframework.stereotype.Component;

@Component("smsNotify")
public class SMSNotificationService implements NotificationService {
    public String send(String message) { return "SMS sent to: " + message; }
}