package com.jungtin.entity.form;


import com.jungtin.entity.Student;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StudentForm {
    private Long id;
    
    @NotBlank
    private String name;
    
    @Pattern(regexp = "(^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}$)?")
    private String birthdate;
    
    public StudentForm(Long id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public StudentForm(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.birthdate = student.getBirthdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
    }
    
    public StudentForm() {
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
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
