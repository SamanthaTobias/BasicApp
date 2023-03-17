package com.example.dockerjavaapp;

import com.example.dockerjavaapp.controller.BasicAppController;
import com.example.dockerjavaapp.service.BasicAppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BasicAppControllerTest {

    @InjectMocks
    private BasicAppController basicAppController;

    @Mock
    private BasicAppService basicAppService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHello() {
        LocalDateTime now = LocalDateTime.now();
        String expectedMessage = "Hello from the app! The current time is " + now;
        when(basicAppService.getHelloMessage()).thenReturn(expectedMessage);

        String actualMessage = basicAppController.hello();

        assertEquals(expectedMessage, actualMessage);
        verify(basicAppService).getHelloMessage();
    }

    @Test
    public void testSetName() {
        String name = "MyApp";
        String expectedResponse = "Name set to '" + name + "'";
        doNothing().when(basicAppService).setAppName(name);

        String actualResponse = basicAppController.setName(name);

        assertEquals(expectedResponse, actualResponse);
        verify(basicAppService).setAppName(name);
    }

}
