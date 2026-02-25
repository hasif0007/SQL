package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {

    @Autowired // Session 17: Field Injection
    private EmailNotificationService emailService;

    private final NotificationService smsService;
    private List<String> employees = new ArrayList<>();

    // Session 18 & 19: Constructor Injection with @Qualifier
    // Removed @Autowired here to fix the yellow warning (it's implicit now)
    public EmployeeService(@Qualifier("smsNotify") NotificationService smsService) {
        this.smsService = smsService;
        this.employees.add("Default Admin"); 
    }

    public String addEmployee(String name) {
        employees.add(name);
        return emailService.send(name) + " | " + smsService.send(name);
    }

    public List<String> getAll() {
        return employees;
    }
}