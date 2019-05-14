package com.example.hz.demo.LocksUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kiva
 */
@EnableAspectJAutoProxy
@Aspect
public class LockHandler {

    @Pointcut("@annotation(Lock)")
    public void pointcut(){

    }


    @Around("pointcut()")
    public void Around(ProceedingJoinPoint joinPoint){
        System.out.println("我是环绕通知后....");
        try {
            
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("我是环绕通知后....");
    }
}
