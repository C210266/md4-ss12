<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit new Customer</h1>
<form action="<%=request.getContextPath()%>/CustomerServlet" method="post">
    <label for="id">ID</label>
    <input type="text" id="id" name="id" disabled value="${customer.id}">
    <input type="hidden"  name="id"  value="${customer.id}">
    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="${customer.name}">
    <label for="email">Email</label>
    <input type="text" id="email" name="email" value="${customer.email}">

    <input type="submit" value="UPDATE" name="action"/>
</form>
</body>
</html>
