package com.example.demo;

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello_controller {

    @Autowired
    private InternshipRepository repo;

    @GetMapping("/hello")
    public String sayHello() {
        return "Student Database System is Live!";
    }

    // 1. REGISTER: This handles the first form in your das.html
    @GetMapping("/add")
    public String addData(@RequestParam String id, @RequestParam String pass) {
        Internship i = new Internship();
        i.setStudentId(id);
        i.setPassword(pass);
        repo.save(i);
        return "Student data for " + id + " saved successfully!";
    }

    // 2. LOGIN: This handles the second form in your das.html
    @GetMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pass) {
        // We now search using String id
        Optional<Internship> student = repo.findById(id);

        if (student.isPresent()) {
            if (student.get().getPassword().equals(pass)) {
                return "Login Successful! Welcome, " + id;
            } else {
                return "Login Failed: Incorrect Password.";
            }
        } else {
            return "Login Failed: Student ID not found.";
        }
    }

    // 3. VIEW ALL: This handles the "View database" link
    @GetMapping("/all")
    public List<Internship> getAllData() {
        return repo.findAll();
    }
}