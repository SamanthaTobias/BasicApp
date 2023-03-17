package com.example.dockerjavaapp;

import com.example.dockerjavaapp.controller.BasicAppController;
import com.example.dockerjavaapp.service.BasicAppService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasicAppControllerTest {

    @InjectMocks
    private BasicAppController basicAppController;

    @Mock
    private BasicAppService basicAppService;

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

    @Test
    public void testReverseString() {
        String input = "hello";
        String expected = "olleh";
        String result = basicAppController.reverseString(input);

        assertEquals(expected, result);
    }

    @Test
    public void testGetLastReversedString() {
        String input = "world";
        String expected = "dlrow";
        basicAppController.reverseString(input);
        String result = basicAppController.getLastReversedString();

        assertEquals(expected, result);
    }

}
