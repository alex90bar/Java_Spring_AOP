package com.example.aspectdemo;

import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecDurationTrackerAspect {

  private Long durationMillis;
  private Logger logger = Logger.getLogger(this.getClass().getName());

  //catches all generate* methods with any set of args
  @Before(value = "execution(public UuidServiceResponse generate*(..))")
  public void beforeDurationTrackingAdvice(JoinPoint joinPoint){
    durationMillis = new Date().getTime();
    logger.info(joinPoint.toString() + " duration tracking begins");
  }

  @After(value = "execution(public UuidServiceResponse generate*(..))")
  public void afterDurationTrackingAdvice(JoinPoint joinPoint){
    durationMillis = new Date().getTime() - durationMillis;
    logger.info(joinPoint.toString() + " generateUuid took: " + (durationMillis) + " mills");
  }

  @Pointcut(value = "execution(* generate*()) ")
  public void allUuidServiceGenerateMethods(){ }

  @After(value = "allUuidServiceGenerateMethods()")
  public void execAdviceForAllUuidServiceGenerateMethods(JoinPoint joinPoint){
    logger.info(joinPoint.getTarget().getClass().getSimpleName() + " was involved");
    //logger.info("advice to all generate methods invoked!");
  }

  @Pointcut(value = "within(com.example.aspectdemo.RandomUuidServiceController)")
  public void allMethodsOfRandomUuidServiceControllerPointcut(){}

  @After(value = "allMethodsOfRandomUuidServiceControllerPointcut()")
  public void allMethodsOfRandomUuidServiceControllerAdvice(JoinPoint joinPoint){
    logger.info("another " + joinPoint.toShortString() + " of Uuid REST service invoked");
   // logger.info("another endpoint of Uuid REST service invoked");
  }

}
