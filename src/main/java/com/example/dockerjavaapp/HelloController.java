package com.example.dockerjavaapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    private String appName = "Docker Java App";

    @GetMapping("/hello")
    public String index() {
        return "Hello from "  + appName + "! The current time is " + LocalDateTime.now();
    }

    @PostMapping("/setName/{name}")
    public String setName(@PathVariable String name) {
        appName = name;
        return "Application name set to: " + appName;
    }

}
