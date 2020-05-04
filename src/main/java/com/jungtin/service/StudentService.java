package com.jungtin.service;

import com.jungtin.entity.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private static HashMap<Long, Student> students = new HashMap<>();
    private Long lastId = 0L;
    
    static {
        StudentService service = new StudentService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        service.saveOrUpdate(new Student("Trung Thinh", LocalDate.parse("22/03/2000", formatter)));
        service.saveOrUpdate(new Student("Hoang Tien", LocalDate.parse("05/03/2000", formatter)));
        service.saveOrUpdate(new Student("Hieu Trung", LocalDate.parse("07/03/2000", formatter)));
        service.saveOrUpdate(new Student("Lam Hoang", LocalDate.parse("14/03/2000", formatter)));
    }
    
    public StudentService() { }
    
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }
    
    public Student saveOrUpdate(Student student) {
        if(student.getId() == null)
            student.setId(++lastId);
        
        students.put(student.getId(), student);
        return student;
    }
    
    public boolean delete(Long id) {
        return students.remove(id) != null;
    }
    
    public Student getStudentById(Long id) {
        return students.get(id);
    }
}
