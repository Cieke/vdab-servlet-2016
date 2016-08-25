<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.realdolmen.servlets.Person" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Register</title>

        <script src="jquery-3.1.0.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>

        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    </head>
    <body>

    <h1>People list</h1>
    List from the database
        <%--TODO: show list of people using EL and JSTL and MVC--%>

    <c:choose>
        <c:when test="${empty people}">
            <p>No people in the database</p>
        </c:when>
        <c:otherwise>
            <ol>
                <c:forEach items="${people}" var="person">
                    <li>
                        ${person.firstName}
                        ${person.lastName}
                        ${person.age}
                        ${person.gender}
                    </li>
                </c:forEach>
            </ol>
        </c:otherwise>
    </c:choose>


    <a href="/register.html"  class="btn btn-primary">Add Person</a>

    </body>
</html>
