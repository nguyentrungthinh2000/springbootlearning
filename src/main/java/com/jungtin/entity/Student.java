package com.jungtin.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private Long id;
    private String name;
    private LocalDate birthdate;
    
    public Student() {
    }
    
    public Student(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public Student(String name, String birthdate) {
        this.name = name;
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
    
    public String getBirthdateStr() {
        return birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
