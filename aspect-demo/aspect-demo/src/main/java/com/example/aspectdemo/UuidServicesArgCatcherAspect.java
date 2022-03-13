package com.example.aspectdemo;

import java.util.logging.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UuidServicesArgCatcherAspect {

  private Logger logger = Logger.getLogger(this.getClass().getName());

  @Pointcut(value = "within(com.example.aspectdemo.*)")
  public void uuidServicesArgCatcherPointcut(){}

//  @After(value = "args(rnd) && uuidServicesArgCatcherPointcut()")
  @AfterReturning(pointcut = "args(rnd) && uuidServicesArgCatcherPointcut()", returning = "response")
  public void uuidServicesArgCatcherAdvice(Double rnd, UuidServiceResponse response){
    response.setUuid(response.getUuid() + "_ADVICE_PART_ADDED");
    logger.info("caught incoming rnd value is: " + rnd);
  }

  @AfterThrowing(pointcut = "args(rnd) && uuidServicesArgCatcherPointcut()", throwing = "ex")
  public void uuidServicesArgCatcherAdvice(Double rnd, Exception ex){

    logger.info("caught incoming rnd value is: " + rnd + " " + ex.getLocalizedMessage());
  }

}
