package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.servlet.http.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import static org.mockito.Mockito.*;

public class HelloServletTest {

    private HelloServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @BeforeEach
    public void setUp() throws Exception {
        servlet = new HelloServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        responseWriter = new StringWriter();

        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testDoGet() throws Exception {
        servlet.doGet(request, response);
        String output = responseWriter.toString().trim();
        assert(output.contains("Hello from Servlet!"));
    }
}
