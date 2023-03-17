package com.example.dockerjavaapp.controller;

import com.example.dockerjavaapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.getHelloMessage();
    }

    @PostMapping("/setName/{name}")
    public String setName(@PathVariable String name) {
        helloService.setAppName(name);
        return "Name set to '" + name + "'";
    }

}
