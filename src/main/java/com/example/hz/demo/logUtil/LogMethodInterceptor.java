package com.example.hz.demo.logUtil;

import com.example.hz.demo.distrubitelock.CacheLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class LogMethodInterceptor {
    final Logger logger = LoggerFactory.getLogger(LogMethodInterceptor.class);

    @Pointcut("@annotation(Log)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public void Around(ProceedingJoinPoint joinPoint){
        System.out.println("我是环绕通知后....");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);

        logger.info(log.before()+ getClass().getName() );
        try {

            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info(log.after());
    }

}
