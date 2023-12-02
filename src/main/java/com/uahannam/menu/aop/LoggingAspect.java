package com.uahannam.menu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.uahannam.menu.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before calling method: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.uahannam.menu.*.*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        System.out.println("Method End: " + joinPoint.getSignature().getName());
    }
}

