package com.realdolmen.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        resp.getWriter().println("ID=" + s.getId());
        resp.getWriter().println(" is new=" + s.isNew());

        s.getAttribute("myColor");
        s.setAttribute("myColor", "red");
        s.removeAttribute("myColor");
        s.invalidate();

    }
}
