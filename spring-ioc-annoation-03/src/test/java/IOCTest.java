import com.atgugu.controller.StudentController;
import com.atgugu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IOCTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-practice.xml");

        StudentController studentController = applicationContext.getBean(StudentController.class);

        List<Student> studentList = studentController.findAll();

        System.out.println(studentList);

        applicationContext.close();
    }
}
