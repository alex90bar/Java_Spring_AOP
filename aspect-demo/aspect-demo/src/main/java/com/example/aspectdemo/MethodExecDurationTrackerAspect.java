package com.example.aspectdemo;

import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.logging.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecDurationTrackerAspect {

  private Long durationMillis;
  private Logger logger = Logger.getLogger(this.getClass().getName());

  @Before(value = "execution(public UuidServiceResponse generateUuid())")
  public void beforeDurationTrackingAdvice(){
    durationMillis = new Date().getTime();
    logger.info("duration tracking begins");
  }

  @After(value = "execution(public UuidServiceResponse generateUuid())")
  public void afterDurationTrackingAdvice(){
    durationMillis = new Date().getTime() - durationMillis;
    logger.info("generateUuid took: " + (durationMillis) + " mills");
  }


}
