package com.realdolmen.servlets;

import com.realdolmen.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/people")
public class PeopleControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDao personDao = PersonDao.getInstance();
        req.setAttribute("people", personDao.findAll());
        req.getRequestDispatcher("/WEB-INF/people.jsp").forward(req, resp);
    }
}
