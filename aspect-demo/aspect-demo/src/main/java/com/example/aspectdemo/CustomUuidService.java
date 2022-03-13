package com.example.aspectdemo;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomUuidService {

  public UuidServiceResponse generateCustomUuid(Double rnd){
    UuidServiceResponse uuidServiceResponse = new UuidServiceResponse();
    uuidServiceResponse.setUuid("Custom_" + UUID.randomUUID().toString());
    //really hard work here
    try {
      Thread.sleep((long) (rnd * 5000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return uuidServiceResponse;
  }

  public UuidServiceResponse generateCustomUuid(){
    UuidServiceResponse uuidServiceResponse = new UuidServiceResponse();
    uuidServiceResponse.setUuid("Custom_" + UUID.randomUUID().toString());
    return uuidServiceResponse;
  }

}
