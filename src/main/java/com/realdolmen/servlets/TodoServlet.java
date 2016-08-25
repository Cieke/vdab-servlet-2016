package com.realdolmen.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/todo")
public class TodoServlet extends HttpServlet {
    public static final String MY_TODO_LIST_ATTRIBUTE = "myTodoList";

    // No doGet, that's covered by todo.jsp now!

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = (List<String>) req.getSession().getAttribute(MY_TODO_LIST_ATTRIBUTE);
        if(list == null) {
            list = new ArrayList<>();
            req.getSession().setAttribute(MY_TODO_LIST_ATTRIBUTE, list);
        }
        String item = req.getParameter("item");
        if(item != null) {
            list.add(item);
        }
        resp.sendRedirect("/todo.jsp");
    }

}
