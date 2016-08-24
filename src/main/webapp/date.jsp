<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8'>
<title>My Todo List</title>
<link rel='stylesheet' href='style.css' type='text/css'>
</head>
<body>
<h1>My <span id='awesome'>super cool</span> todo list</h1>
<form method='post'>
<input type='text' name='item'/>
<input type='submit' value='Add item'/>


    <%
    java.util.List<String> myTodoList = request.getSession().getAttribute("myTodoList");
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

</form>
</body>
</head>
</html>