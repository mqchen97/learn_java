package com.atgugu.dao.impl;

import com.atgugu.dao.StudentDao;
import com.atgugu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> queryAll() {
        String sql = "SELECT id, name, age, gender, class as className FROM students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentDao" + studentList);
        return studentList;
    }
}
