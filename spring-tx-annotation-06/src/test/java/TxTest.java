import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class TxTest {

    @Autowired
    private StudentController studentController;

    @Test
    public void testTx(){
        studentController.changeInfo();
    }
}
