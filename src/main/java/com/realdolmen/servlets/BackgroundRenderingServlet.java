package com.realdolmen.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/background")
public class BackgroundRenderingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = getCookieValue(req, "myColor", "red");
        String f = getCookieValue(req, "myFontSize", "12pt");
        String l = getCookieValue(req, "myLanguage", "en");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Example with cookie</title></head>");
        out.println("<body style='background-color: " + c + "'>Hello World</body>");
        out.println("</html>");
    }

    private String getCookieValue(HttpServletRequest req, String wantedCookieName, String unfoundDefault) {
        Cookie[] allCookies = req.getCookies();
        for (Cookie aCookie : allCookies) {
            if(aCookie.getName().equals(wantedCookieName)) {
                // ! This is the one we're looking for
                return aCookie.getValue();
            }
        }
        return unfoundDefault;
    }
}
