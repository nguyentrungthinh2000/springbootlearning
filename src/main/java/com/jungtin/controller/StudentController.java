package com.jungtin.controller;


import com.jungtin.entity.Student;
import com.jungtin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/create")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }
    
    @PostMapping("/submit")
    public String processForm(@ModelAttribute("student") Student student) {
        studentService.saveOrUpdate(student);
        return "redirect:/#student";
    }
    
    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/#student";
    }
    
    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "form";
    }
    
}
