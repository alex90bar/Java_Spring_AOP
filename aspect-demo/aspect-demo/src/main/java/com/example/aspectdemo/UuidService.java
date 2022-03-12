package com.example.aspectdemo;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UuidService {

//  private Logger logger = Logger.getLogger(this.getClass().getName());

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
