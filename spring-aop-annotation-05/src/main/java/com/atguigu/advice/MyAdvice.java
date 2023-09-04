package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 * */
@Aspect
@Component
public class MyAdvice {
    /**
     *
     * @param joinPoint 获取对象的信息
     */
    @Before("com.atguigu.pointCut.MyPointCut.pc()")
    public void before(JoinPoint joinPoint){
        String simpleName = joinPoint.getTarget().getClass().getSimpleName(); // 获取方法属于的类信息
        System.out.println("simpleName = " + simpleName);

        int modifiers = joinPoint.getSignature().getModifiers(); // 获取方法信息: 访问修饰符 返回参数类型

        String s = Modifier.toString(modifiers);
        System.out.println("modifiers = " + s);

        String name = joinPoint.getTarget().getClass().getName(); // 获取类名
        System.out.println("name = " + name);

        Object[] args = joinPoint.getArgs(); // 获取目标方法参数
        System.out.println("args = " + Arrays.toString(args));



    }

    @AfterReturning(value = "com.atguigu.pointCut.MyPointCut.pc()", returning = "result") // 接收返回结果, returning = 形参名
    public void afterReturning(Object result){
        System.out.println("result = " + result);
    }

    @AfterThrowing(value = "com.atguigu.pointCut.MyPointCut.pc()", throwing = "throwing")
    public void afterThrowing(Throwable throwing){
        System.out.println("throwing = " + throwing);
    }

    @After("com.atguigu.pointCut.MyPointCut.pc()")
    public void after(){
        System.out.println("finally");
    }
}
