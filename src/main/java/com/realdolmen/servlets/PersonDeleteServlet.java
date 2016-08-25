package com.realdolmen.servlets;

import com.realdolmen.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteperson")
public class PersonDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        try {
            int personId = Integer.parseInt(req.getParameter("id"));
            PersonDao.getInstance().remove(personId);
            resp.sendRedirect("/people");
        }
        catch (NumberFormatException e) {
            resp.sendError(422, "Parameter id is mandatory");


        }



    }
}
