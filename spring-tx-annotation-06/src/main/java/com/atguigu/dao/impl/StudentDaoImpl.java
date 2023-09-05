package com.atguigu.dao.impl;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void updateNameById(String name, Integer id) {
        String sql = "update students set name = ? where id = ? ;";
        int rows = jdbcTemplate.update(sql, name, id);
    }

    @Override
    public void updateAgeById(Integer age, Integer id) {
        String sql = "update students set age = ? where id = ? ;";
        jdbcTemplate.update(sql,age,id);
    }
}
