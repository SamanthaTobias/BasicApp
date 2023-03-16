package com.example.dockerjavaapp;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelloService {

    private String appName = "My Java App";

    public String getHelloMessage() {
        LocalDateTime currentTime = LocalDateTime.now();
        return "Hello from " + appName + "! The current time is " + currentTime;
    }

    public void setAppName(String name) {
        appName = name;
    }

}
