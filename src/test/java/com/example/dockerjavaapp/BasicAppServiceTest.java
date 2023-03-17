package com.example.dockerjavaapp;

import com.example.dockerjavaapp.service.BasicAppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAppServiceTest {

    private BasicAppService basicAppService;

    @BeforeEach
    public void setUp() {
        basicAppService = new BasicAppService();
    }

    @Test
    public void testGetHelloMessage() {
        String response = basicAppService.getHelloMessage();

        String expectedMessage = "Hello from My Java App!";
        assertTrue(response.contains(expectedMessage));
    }

    @Test
    public void testSetAppName() {
        String expectedAppName = "My New App";
        basicAppService.setAppName(expectedAppName);

        String response = basicAppService.getHelloMessage();

        assertTrue(response.contains(expectedAppName));
    }

}