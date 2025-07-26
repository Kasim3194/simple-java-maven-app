package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");

        String html = "<!DOCTYPE html>" +
                "<html>" +
                "<head><title>Welcome Page</title></head>" +
                "<body>" +
                "<h1>Hello, Students! 👋</h1>" +
                "<h1>Welcome to NewGen Software! 👋</h1>" +
                "<p><strong>App:</strong> Simple Java Maven App</p>" +
                "<p><strong>Environment:</strong> Production</p>" +
                "<p><strong>Version:</strong> 1.0-SNAPSHOT</p>" +
                "<p><strong>Accessed At:</strong> " + LocalDateTime.now() + "</p>" +
                "<hr>" +
                "<p>Thank you for deploying with Jenkins CI/CD 🚀</p>" +
                "</body>" +
                "</html>";

        resp.getWriter().write(html);
    }
}
