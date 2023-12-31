<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1,table{
            width: 60%;
            text-align: center;
            margin: 0 auto 50px;
        }
    </style>
</head>
<body>
<h1>List Customer</h1>
<table border="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <a href="<%=request.getContextPath()%>/CustomerServlet?action=CREATE">ADD</a>
    <c:forEach items="${customers}" var="c" varStatus="item">
        <tr>
            <td>${item.count}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td><a href="<%=request.getContextPath()%>/CustomerServlet?action=SHOW&id=${c.id}">Show</a></td>
            <td><a href="<%=request.getContextPath()%>/CustomerServlet?action=EDIT&id=${c.id}">Edit</a></td>
            <td><a onclick="return confirm('Do you want to delete this student ?')"
                   href="<%=request.getContextPath()%>/CustomerServlet?action=DELETE&id=${c.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
