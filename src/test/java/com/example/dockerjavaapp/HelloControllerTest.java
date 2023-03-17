package com.example.dockerjavaapp;

import com.example.dockerjavaapp.controller.HelloController;
import com.example.dockerjavaapp.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HelloControllerTest {

    @InjectMocks
    private HelloController helloController;

    @Mock
    private HelloService helloService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHello() {
        LocalDateTime now = LocalDateTime.now();
        String expectedMessage = "Hello from the app! The current time is " + now;
        when(helloService.getHelloMessage()).thenReturn(expectedMessage);

        String actualMessage = helloController.hello();

        assertEquals(expectedMessage, actualMessage);
        verify(helloService).getHelloMessage();
    }

    @Test
    public void testSetName() {
        String name = "MyApp";
        String expectedResponse = "Name set to '" + name + "'";
        doNothing().when(helloService).setAppName(name);

        String actualResponse = helloController.setName(name);

        assertEquals(expectedResponse, actualResponse);
        verify(helloService).setAppName(name);
    }

}
