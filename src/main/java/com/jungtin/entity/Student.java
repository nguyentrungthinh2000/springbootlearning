package com.jungtin.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private Long id;
    
    private String name;
    
    private LocalDate birthdate;
    
    public Student() {
    }
    
    public Student(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public Student(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public Student(StudentForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.birthdate = LocalDate.parse(form.getBirthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
    
    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", birthdate=" + birthdate +
            '}';
    }
}
