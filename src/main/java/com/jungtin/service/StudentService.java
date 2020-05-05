package com.jungtin.service;

import com.jungtin.entity.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public StudentService() { }
    
    public List<Student> getStudents() {
        List<Student> students = jdbcTemplate
            .query("SELECT * FROM STUDENT", new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int i) throws SQLException {
                    Student temp = new Student(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate()
                    );
                    return temp;
                }
            });
        return students;
    }
    
    public Student saveOrUpdate(Student student) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
            .withTableName("STUDENT")
            .usingGeneratedKeyColumns("ID");

        Map<String, Object> params = new HashMap<>();
        params.put("ID", student.getId());
        params.put("NAME", student.getName());
        params.put("BIRTHDATE", student.getBirthdate());

        Number returnedId = insert.executeAndReturnKey(params);
        student.setId(returnedId.longValue());
    
        return student;
    }
    
    public boolean delete(Long id) {
        int result = jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", id);
        return result > 0;
    }
    
    public Student getStudentById(Long id) {
        Student student = jdbcTemplate
            .queryForObject("SELECT * FROM STUDENT WHERE ID = ?", new Object[]{id},
                new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int i) throws SQLException {
                        Student temp = new Student(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getDate(3).toLocalDate()
                        );
                        return temp;
                    }
                });
        return student;
    }
    
    public void checkConnection() {
        try {
            final Connection connection = dataSource.getConnection();
            if (connection == null) {
                System.out.println("no connection");
            } else {
                System.out.println("yes connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
