package com.atgugu.controller;

import com.atgugu.pojo.Student;
import com.atgugu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public List<Student> findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("finally: " + studentList);
        return studentList;
    }
}
