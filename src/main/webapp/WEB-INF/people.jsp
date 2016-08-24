<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
    <head>
        <title>People</title>

        <script src="jquery-3.1.0.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>

        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    </head>
    <body>
        <div class="container">
            <h1>This is a list of people</h1>
            <p>And it demonstrates the MVC pattern (with an actual database)</p>
            <table class="table table-striped">
                 <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Age</th>
                    <th>Gender</th>
                </tr>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td>${person.firstName}</td>
                        <td>${person.lastName}</td>
                        <td>${person.age}</td>
                        <td>${person.gender}</td>
                </c:forEach>
            </table>
            <a href="register.html" class="btn btn-primary">Add new person</a>
        </div>
    </body>
</html>
