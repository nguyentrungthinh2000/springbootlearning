package com.jungtin.entity;

import java.time.LocalDate;

public class Teacher {
    private Long id;
    private String name;
    private LocalDate birthdate;
    private SUBJECT subject;
    
    public Teacher() {
    }
    
    public Teacher(Long id, String name, LocalDate birthdate, SUBJECT subject) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.subject = subject;
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
    
    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    public SUBJECT getSubject() {
        return subject;
    }
    
    public void setSubject(SUBJECT subject) {
        this.subject = subject;
    }
}
