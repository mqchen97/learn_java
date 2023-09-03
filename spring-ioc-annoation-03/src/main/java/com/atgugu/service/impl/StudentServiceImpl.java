package com.atgugu.service.impl;

import com.atgugu.dao.StudentDao;
import com.atgugu.pojo.Student;
import com.atgugu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("Service: " + studentList);
        return studentList;
    }
}
