package com.jungtin.service;

import com.jungtin.entity.SUBJECT;
import com.jungtin.entity.Teacher;
import com.jungtin.entity.form.TeacherForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Teacher> getTeachers() {
        final List<Teacher> teachers = jdbcTemplate
            .query("SELECT * FROM teacher", new RowMapper<Teacher>() {
                @Override
                public Teacher mapRow(ResultSet rs, int i) throws SQLException {
                    Teacher temp = new Teacher(
                        rs.getLong(1),
                        rs.getString(2),
                        SUBJECT.valueOf(rs.getString(3))
                    );
                    return temp;
                }
            });
        
        return teachers;
    }
    
    public Teacher saveOrUpdate(TeacherForm form) {
        Teacher teacher = new Teacher(form);
        if(form.getId() == null) {
            /*
            *   INSERT
            * */
            SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
                .withTableName("teacher")
                .usingGeneratedKeyColumns("id");
    
            Number returnedId = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(form));
            teacher.setId(returnedId.longValue());
        } else {
            jdbcTemplate.update("UPDATE teacher SET name = ?, subject = ? WHERE id = ?"
                    ,form.getName()
                    ,form.getSubject().toString()
                    ,form.getId()
            );
        }
        
        return teacher;
    }
    
    public boolean delete(Long id) {
        int result = jdbcTemplate.update("DELETE FROM teacher WHERE ID = ?", id);
        return result > 0;
    }
    
    public Teacher getTeacherById(Long id) {
        Teacher teacher = jdbcTemplate
            .queryForObject("SELECT * FROM teacher WHERE ID = ?", new Object[]{id},
                new RowMapper<Teacher>() {
                    @Override
                    public Teacher mapRow(ResultSet rs, int i) throws SQLException {
                        Teacher temp = new Teacher(
                            rs.getLong(1),
                            rs.getString(2),
                            SUBJECT.valueOf(rs.getString(3))
                        );
                        return temp;
                    }
                });
        return teacher;
    }
}
