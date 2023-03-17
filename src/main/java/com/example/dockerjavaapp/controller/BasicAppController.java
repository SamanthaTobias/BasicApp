package com.example.dockerjavaapp.controller;

import com.example.dockerjavaapp.service.BasicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAppController {

    @Autowired
    private BasicAppService basicAppService;

    @GetMapping("/hello")
    public String hello() {
        return basicAppService.getHelloMessage();
    }

    @PostMapping("/setName/{name}")
    public String setName(@PathVariable String name) {
        basicAppService.setAppName(name);
        return "Name set to '" + name + "'";
    }

}
