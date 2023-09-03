package com.atguigu.test;

import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_03.InterfaceHappy;
import com.atguigu.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpirngIocTest {

    public void createIOC(){
        //  BeanFactory (interface)
        //  -->  ApplicationContext (interface)
        //  --> class:
        //  {
        //      ClassPathXmlApplicationContext,
        //      FileSystemXmlApplicationContext,
        //      AnnotationConfigApplicationContext,
        //      WebApplicationContext
        //  }
        // 1, 经常方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03");
        // 2. 源码方式
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocation("spring-03");
        applicationContext1.refresh();
    }

    @Test
    public void getBeanFormIOC(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("spring-03.xml");
        applicationContext.refresh();

        HappyComponent happyComponent1 = (HappyComponent) applicationContext.getBean("happyComponent");
        HappyComponent happyComponent2 = applicationContext.getBean("happyComponent", HappyComponent.class);
        InterfaceHappy happyComponent3 = applicationContext.getBean(InterfaceHappy.class);

        happyComponent3.doWork();

        System.out.println(happyComponent1 == happyComponent2);
    }

    @Test
    public void test_04(){

        // 创建ioc容器就会进行组件实例化init方法
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        // 调用销毁方法clear
        applicationContext.close();

    }

    @Test
    public void test_05(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        JavaBean javaBean = applicationContext.getBean(JavaBean.class);

        System.out.println("javaBean: " + javaBean);

        // FactoryBean工厂也会加载到IOC中 name: &id
        Object bean = applicationContext.getBean("&javaBean");

        System.out.println("FactoryBean: " + bean);
    }
}
