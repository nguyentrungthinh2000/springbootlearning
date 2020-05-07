package com.jungtin.controller;

import com.jungtin.service.StudentService;
import com.jungtin.service.TeacherService;
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
    
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("teachers", teacherService.getTeachers());
        return "index";
    }
    
}
