package com.realdolmen.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cookie.html")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Setting a cookie
        resp.addCookie(new Cookie("myName", "Jimi"));
        Cookie colorCookie = new Cookie("myColor", req.getParameter("myColor"));
        colorCookie.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(colorCookie);

        // Reading cookies (possibly another servlet)
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("myName")) {
                // This is the one!
                resp.getWriter().println("OK " + cookie.getValue());
            }
        }



    }
}
