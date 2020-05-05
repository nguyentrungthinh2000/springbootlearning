package com.jungtin.controller;

import com.jungtin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        
        return "index";
    }
    
}
