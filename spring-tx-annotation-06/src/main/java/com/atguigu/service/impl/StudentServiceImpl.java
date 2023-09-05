package com.atguigu.service.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    @Transactional(
            timeout = 4,
            rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class,
            isolation = Isolation.READ_COMMITTED
    )
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(100,1);
        new FileInputStream("xxx");
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true) //只读模式
    public void queryInfo(){

    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(99,1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("test2",1);
        int i = 1/0;
    }
}
