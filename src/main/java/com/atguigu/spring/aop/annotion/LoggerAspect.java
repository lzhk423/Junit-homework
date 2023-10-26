package com.atguigu.spring.aop.annotion;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面中需要使用指定的注解将方法标识为通知方法
 * 切入点表达式 设置在切面前 定位具体方法
 *  具体：
 *   @Before("execution(public int com.atguigu.spring.aop.annotion.CalculatorImpl.add(int,int))")
 *   全部：
 *     @Before("execution(* com.atguigu.spring.aop.annotion.CalculatorImpl.*(..))")
 *     获取连接点对应方法的信息
 *     public void beforeAdviceMethod(JoinPoint joinPoint)
 *     切面方法加入 JoinPoint joinPoint参数
 *     通过JoinPoint 获取信息
 *     @Pointcut
 *     声明一个公共的切入点表达式
 */

@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.atguigu.spring.aop.annotion.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法名：" + signature.getName() + "," + "形参:" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("后置通知,方法名：" + signature.getName());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("返回通知,方法名：" + signature.getName() + ",结果：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("异常通知,方法名:" + signature.getName() + "，异常为：" + ex);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");           result = joinPoint.proceed();

            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知-->异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}




















//@Component
//@Aspect
////@Aspect 将当前组件表示为切面
//public class LoggerAspect {
//    @Pointcut("execution(* com.atguigu.spring.aop.annotion.CalculatorImpl.*(..))")
//    public void poinCut(){
//
//    }
////    标识为前置通知
////    @Before("execution(public int com.atguigu.spring.aop.annotion.CalculatorImpl.add(int,int))")
//    @Before("poinCut()")
//        public void beforeAdviceMethod(JoinPoint joinPoint){
////        获取连接点的方法信息
//        Signature signature = joinPoint.getSignature();
////        获取连接点的参数
//        Object[] args = joinPoint.getArgs();
//        System.out.println("LoggerAspect,前置通知,方法名："+signature.getName()+","+"形参:"+ Arrays.toString(args));
// }
//// 后置通知 在finally子句中执行
//    @After("poinCut()")
//    public void afterAdiceMethod(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("后置通知,方法名："+signature.getName());
//    }
////    返回通知 在目标方法执行后执行 有异常不执行
////    returning = "result" 设置接受目标方法的返回值的参数
//    @AfterReturning(value="poinCut()",returning = "result")
//    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("返回通知,方法名："+signature.getName()+",结果："+result);
//    }
////    异常通知   ,throwing = "ex" 接受方法的异常参数
//    @AfterThrowing(value = "poinCut()",throwing = "ex")
//    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("异常通知,方法名:"+signature.getName()+"，异常为："+ex);
//    }
////    环绕通知
//
//    /**
//     *
//     * @param joinPoint
//     */
//    @Around("poinCut()")
//    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
//        Object result =null;
//        try {
//            System.out.println("环绕通知-->前置通知");
////            表示目标方法的执行
//           result=  joinPoint.proceed();
//            System.out.println("环绕通知-->返回通知");
//        } catch (Throwable e) {
//            System.out.println("环绕通知-->异常通知");
//            throw new RuntimeException(e);
//        }finally {
//            System.out.println("环绕通知-->后置通知");
//        }
//       return result;
//    }
//}

