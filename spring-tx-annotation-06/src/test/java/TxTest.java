import com.atguigu.config.JavaConfig;
import com.atguigu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class TxTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testTx() throws FileNotFoundException {
        studentService.changeInfo();
    }
}
