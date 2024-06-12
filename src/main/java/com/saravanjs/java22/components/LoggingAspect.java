package com.saravanjs.java22.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package components
 * @class LoggingAspect
 */

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.saravanjs.java22..*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBefore() {
        System.out.println("Method execution started");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Method execution completed with result: " + result);
    }
}