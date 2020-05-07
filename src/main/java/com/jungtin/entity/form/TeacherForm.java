package com.jungtin.entity.form;

import com.jungtin.entity.SUBJECT;
import com.jungtin.entity.Teacher;
import java.util.List;
import javax.validation.constraints.NotBlank;

public class TeacherForm {
    private Long id;
    
    @NotBlank
    private String name;
    private SUBJECT subject;
    
    public TeacherForm() {
    }
    
    public TeacherForm(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.subject = teacher.getSubject();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public SUBJECT getSubject() {
        return subject;
    }
    
    public void setSubject(SUBJECT subject) {
        this.subject = subject;
    }
    
    public List<SUBJECT> getSubjects() {
        return List.of(SUBJECT.values());
    }
}
