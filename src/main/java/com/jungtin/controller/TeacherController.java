package com.jungtin.controller;


import com.jungtin.entity.Teacher;
import com.jungtin.entity.form.TeacherForm;
import com.jungtin.service.TeacherService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping("/create")
    public String showTeacherForm(Model model) {
        model.addAttribute("teacher", new TeacherForm());
        return "teacher/form";
    }
    
    @PostMapping("/submit")
    public String processForm(@Valid @ModelAttribute("teacher") TeacherForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "teacher/form";
        }
        teacherService.saveOrUpdate(form);
        return "redirect:/#teacher";
    }
    
    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return "redirect:/#teacher";
    }
    
    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", new TeacherForm(teacher));
        return "teacher/form";
    }
    
}
