package com.example.aspectdemo;

import java.util.logging.Logger;
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

  @Before(value = "args(rnd) && uuidServicesArgCatcherPointcut()")
  public void uuidServicesArgCatcherAdvice(Double rnd){
    logger.info("caught incoming rnd value is: " + rnd);
  }

}
