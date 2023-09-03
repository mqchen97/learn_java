import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();

        applicationContext.close();
    }


}
