package com.jungtin.entity;

import com.jungtin.entity.form.TeacherForm;

public class Teacher {
    private Long id;
    private String name;
    private SUBJECT subject;
    
    public Teacher() {
    }
    
    public Teacher(String name, SUBJECT subject) {
        this.name = name;
        this.subject = subject;
    }
    
    public Teacher(Long id, String name, SUBJECT subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
    
    public Teacher(TeacherForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.subject = form.getSubject();
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
    
    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
