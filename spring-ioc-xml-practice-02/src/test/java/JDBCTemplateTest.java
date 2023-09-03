import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCTemplateTest {

    @Test
    public void testForJava() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO students (name, gender, age, class) VALUES (?,?,?,?)";

        int rows = jdbcTemplate.update(sql, "李四", "男", 20, "软设一班");
        System.out.println("rows: " + rows);
    }

    @Test
    public void testForIOC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

//        String sql = "INSERT INTO students (name, gender, age, class) VALUES (?,?,?,?)";
//
//        int rows = jdbcTemplate.update(sql, "李四", "男", 20, "软设一班");
//        System.out.println("rows: " + rows);

        String sql = "SELECT * FROM students WHERE id = ?";
        Student stu = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClassName(rs.getString("class"));
            return student;
        }, 1);
        System.out.println("stu: " + stu);

        sql = "SELECT id, name, age, gender, class as className FROM students";

        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("stu2: " + students);
    }

    @Test
    public void queryAllTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();

        applicationContext.close();
    }
}
