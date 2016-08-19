package com.realdolmen.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DualServlet extends HttpServlet {
    private int maxSize;

    // See this as a "constructor" for the servlet
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("CREATING SERVLET NOW");
        maxSize = Integer.parseInt(config.getInitParameter("maxSize"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ...
        System.out.println("GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ...
    }
}
