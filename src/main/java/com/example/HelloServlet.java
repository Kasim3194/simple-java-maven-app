package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HelloServletTest {

    private HelloServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new HelloServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);
        writer.flush();

        String output = stringWriter.toString();
        
        // Check for a few important expected parts
        assertTrue(output.contains("Hello from DevSecOps Labs"));
        assertTrue(output.contains("Simple Java Maven App"));
        assertTrue(output.contains("Deployed via Jenkins"));

        // Optional: print output for debugging
        System.out.println("Servlet Output:\n" + output);
    }
}
