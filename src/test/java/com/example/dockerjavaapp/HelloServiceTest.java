package com.example.dockerjavaapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloServiceTest {

    private HelloService helloService;

    @BeforeEach
    public void setUp() {
        helloService = new HelloService();
    }

    @Test
    public void testGetHelloMessage() {
        String response = helloService.getHelloMessage();

        String expectedMessage = "Hello from My Java App!";
        assertTrue(response.contains(expectedMessage));
    }

    @Test
    public void testSetAppName() {
        String expectedAppName = "My New App";
        helloService.setAppName(expectedAppName);

        String response = helloService.getHelloMessage();

        assertTrue(response.contains(expectedAppName));
    }

}