package com.example.dockerjavaapp.controller;

import com.example.dockerjavaapp.service.BasicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicAppController {

    private String lastReversedString = "";

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

    @GetMapping("/reverse")
    public String reverseString(@RequestParam String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        lastReversedString = reversed;
        return reversed;
    }

    @GetMapping("/lastReversed")
    public String getLastReversedString() {
        return lastReversedString;
    }

}
