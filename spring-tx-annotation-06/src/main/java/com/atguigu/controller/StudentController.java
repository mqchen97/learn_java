package com.atguigu.controller;

import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void changeInfo(){
        studentService.changeInfo();
    }
}
