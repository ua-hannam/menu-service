package com.uahannam.menu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.aop.controller..*.*(..))")
    private void cut(){}

    @Before("cut()")
    public void logBefore(JoinPoint joinPoint) {
        Method method = getMethod(joinPoint);
        log.info("Before calling method: {}", method.getName());

        Object[] args = joinPoint.getArgs();
        if (args.length == 0) log.info("no parameter");
        for (Object arg : args) {
            log.info("parameter type = {}", arg.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }
    }

    @After("execution(* com.uahannam.menu.*.*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        System.out.println("Method End: " + joinPoint.getSignature().getName());
    }

    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}

