package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/view") // Session 20: HTML Output
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "index"; 
    }

    @GetMapping("/add") // Session 17-19: Text Output
    @ResponseBody
    public String add(@RequestParam String name) {
        return employeeService.addEmployee(name);
    }
}