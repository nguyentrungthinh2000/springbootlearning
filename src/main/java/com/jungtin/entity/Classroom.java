package com.jungtin.entity;

import java.util.Set;

public class Classroom {
    private Long id;
    private String name;
    private Set<Student> students;
    private Teacher teacher;
    
    public Classroom(String name, Set<Student> students, Teacher teacher) {
        this.name = name;
        this.students = students;
        this.teacher = teacher;
    }
    
    public Classroom(String name) {
        this.name = name;
    }
    
    public Classroom(Long id, String name, Set<Student> students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.teacher = teacher;
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
    
    public Set<Student> getStudents() {
        return students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
}
