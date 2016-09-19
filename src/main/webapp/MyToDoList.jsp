<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>To Do List</title>
</head>
<body>
<h2 style="margin: 25px" align="center" >To Do List</h2>
<table style="background-color: #FCF8E3; border-style: solid;" width="75%" border="1" align="center">
    <tr style="height: 30px" bgcolor=white>
        <th width="80%">Name</th>
        <th width="10%">Complete</th>
        <th width="10%" style="border: 0"></th>
    </tr>

    <c:forEach items="${list}" var="current">
        <tr>
            <td><c:out value="${current.getName()}"/></td>
            <td align="center"><input type="checkbox"></td>
            <td align="center" bgcolor="white" style="border: 0; margin-top: auto;">
                <form action="deleteTask" method="get">
                <input style="margin-top: 15px" type="submit" name="${current.getUuid()}" value="delete">
                <c:set var="button_id" value="${current.getUuid()}"/>
                </form>
            </td>

        </tr>
    </c:forEach>

    <form action="createTask" method="post">
        <table  align="center" style="border-top-color: grey; margin-top: 25px" width="75%">
            <tr>
                <td>Task Name</td>
                <td><input type="text" name="enteredTask" value="Enter your task" size="50"/>
                    <input style="margin-left: 25px" type="submit" value="Submit" name="submit">
                </td>
            </tr>
        </table>

    </form>


</table>
</body>
</html>
