package com.atguigu.spring.aop.annotion;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {
    /**
     * 可以在不同切面访问其中切面有配置的切入点表达式
     * 配置切面的访问优先级 @Order(int ) 数字越小优先级越高 默认值为Integer的最大值
     *
     */
//    @Before("execution(* com.atguigu.spring.aop.annotion.CalculatorImpl.*(..))")
    @Before("com.atguigu.spring.aop.annotion.LoggerAspect.poinCut()")
    public void beforeMerhod(){
        System.out.println("ValidateAspect-->前置通知");
   }
}
