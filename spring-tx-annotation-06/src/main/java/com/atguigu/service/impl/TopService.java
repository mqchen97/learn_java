package com.atguigu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopService {
    @Autowired
    private StudentServiceImpl studentService;

    @Transactional
    public void  topService(){
        studentService.changeAge();
        studentService.changeName();
    }
}
