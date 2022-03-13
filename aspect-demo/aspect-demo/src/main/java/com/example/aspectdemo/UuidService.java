package com.example.aspectdemo;

import com.example.aspectdemo.annotations.ArgsCatchable;
import com.example.aspectdemo.annotations.DurationTrackable;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UuidService {

//  private Logger logger = Logger.getLogger(this.getClass().getName());

  @DurationTrackable
  @ArgsCatchable
  public UuidServiceResponse generateUuid(Double rnd) {

    UuidServiceResponse uuidServiceResponse = new UuidServiceResponse();
    uuidServiceResponse.setUuid(UUID.randomUUID().toString());
    //really hard work here
    try {
      Thread.sleep((long) (rnd * 5000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return uuidServiceResponse;
  }

  public UuidServiceResponse generateUuid() {
//    logger.info("generateUuid() begins");
//    Date dateBegin = new Date();
    UuidServiceResponse uuidServiceResponse = new UuidServiceResponse();
    uuidServiceResponse.setUuid(UUID.randomUUID().toString());
    //really hard work here
    try {
      Thread.sleep((long) (Math.random() * 5000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    Date dateEnd = new Date();
//    logger.info("generateUuid took: " + (dateEnd.getTime() - dateBegin.getTime()) + " mills");
    return uuidServiceResponse;
  }
}
