<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.realdolmen.servlets.TodoServlet" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset='UTF-8'>
        <title>My Todo List</title>
        <link rel='stylesheet' href='style.css' type='text/css'>
    </head>
    <body>
        <h1>My <span id='awesome'>super cool</span> todo list</h1>
        <form method='post' action="/todo">
            <input type='text' name='item'/>
            <input type='submit' value='Add item'/>
        </form>

        <%-- New way --%>
        <c:choose>
            <c:when test="${empty myTodoList}">
                <p>Your list is empty</p>
            </c:when>
            <c:otherwise>
                <ol>
                    <c:forEach items="${myTodoList}" var="item">
                        <li>${item}</li>
                    </c:forEach>
                </ol>
            </c:otherwise>
        </c:choose>

        <%-- Old way --%>
        <%
            List<String> myTodoList = (List<String>)request.getSession().getAttribute("myTodoList");
            if(myTodoList == null || myTodoList.isEmpty()) {
                out.println("<p>Your list is empty</p>");
            } else {
                out.println("<ol>");
                for (String item : myTodoList) {
                    out.println("<li>" + item + "</li>");
                }
                out.println("</ol>");
            }
        %>

    </body>
</html>