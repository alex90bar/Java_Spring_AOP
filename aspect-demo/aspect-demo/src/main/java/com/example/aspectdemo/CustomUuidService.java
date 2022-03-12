package com.example.aspectdemo;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomUuidService {

  public UuidServiceResponse generateCustomUuid(){
    UuidServiceResponse uuidServiceResponse = new UuidServiceResponse();
    uuidServiceResponse.setUuid("Custom_" + UUID.randomUUID().toString());
    return uuidServiceResponse;
  }

}
