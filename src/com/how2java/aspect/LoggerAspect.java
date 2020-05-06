package com.how2java.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

    @Around(value = "execution(* com.how2java.service.ProductService.*(..))")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime(); // 获取开始时间
        Object object = joinPoint.proceed();
        long endTime = System.nanoTime(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
        return object;
    }

    @Around(value = "execution(* com.how2java.service.ProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }


}
