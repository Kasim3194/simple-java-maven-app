package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

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
        assert(stringWriter.toString().contains("Hello, World!"));
    }
}
