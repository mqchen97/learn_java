package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    @Around("com.atguigu.pointCut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object result = null;

        try {
            // 这里写before语句
            result = joinPoint.proceed(args);
            // afterReturning
        }catch (Throwable e){
            // afterThrowing
            throw new RuntimeException(e);
        }finally {
            // after
        }

        return result;
    }
}
