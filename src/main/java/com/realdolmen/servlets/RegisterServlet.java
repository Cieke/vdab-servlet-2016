package com.realdolmen.servlets;

import com.realdolmen.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doRegister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        Gender gender = Gender.valueOf(req.getParameter("gender"));

        Person p = new Person(firstName, lastName, age, gender);
        System.out.println(p);
        resp.sendRedirect("/people");


        PersonDao.getInstance().save(p);

    }
}
