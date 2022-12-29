package com.nhnacademy.edu.springframework.project.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@EnableAspectJAutoProxy(exposeProxy = true)
public class LoggingAspect {
//
//    @Pointcut("bean(csvDataLoadService)")
    @Pointcut("execution(* com.nhnacademy.edu.springframework.project.service..*(..))")
    private void timecheck() {
    }

//    @Pointcut("@annotation(com.nhnacademy.edu.springframework.project.AOP.TimeLogging)")
//    private void enableTimer() {
//    }
//
//    &&enableTimer()
    @Around("timecheck()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retval = pjp.proceed();
        stopWatch.stop();
       Object timer = pjp.proceed();

        System.out.println("["+pjp.getTarget().getClass().getSimpleName()+"]"
            +"["+pjp.getSignature().getName()+"]"
            +"["+stopWatch.getTotalTimeSeconds()+"]ms");
       return timer;

    }
}
