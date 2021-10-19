package com.example.bookslibrary.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("method()")
    public void logging(JoinPoint joinPoint){
        log.info("hello");
        System.out.println(joinPoint.toLongString());
    }

    @Pointcut("execution(* printText(..))")
    public void method(){}

}
