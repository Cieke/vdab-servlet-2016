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
    <div class="container">
    <h1>People list</h1>

        <%--TODO: show list of people using EL and JSTL and MVC--%>

    <c:choose>
        <c:when test="${empty people}">
            <p>No people in the database</p>
        </c:when>
        <c:otherwise>



                    <table class="table table-hover" border-spacing="10px">
                       <tr>
                           <th>ID</th>
                           <th>Firstname</th>
                           <th>Lastname</th>
                           <th>gender</th>
                           <th>Age</th>
                           <th></th>
                       </tr>
            <c:forEach items="${people}" var="person">
                       <tr>
                           <td>${person.id}</td>
                           <td>${person.firstName}</td>
                           <td>${person.lastName}</td>
                           <td>${person.gender}</td>
                           <td>${person.age}</td>
                           <td><a href="/deleteperson?id=${person.id}" class="btn btn-xs btn-danger">Remove</a> </td>
                       </tr>

            </c:forEach>
                    </table>


        </c:otherwise>
    </c:choose>


    <a href="/register.html"  class="btn btn-primary">Add Person</a>

        <!--verwijderen van record: nummer van record nodig-->



    </div>
    </body>
</html>
