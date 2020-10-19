<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2020
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="/user/registration" modelAttribute="user" method="post">
    <s:input type="text" path="name"/>
    name
    <br>
    <s:errors path="name"/>
    <br>
    <s:input type="text" path="login"/>
    login
    <br>
    <s:errors path="login"/>
    <br>
    <s:input type="text" path="password"/>
    password
    <br>
    <s:errors path="password"/>
    <br>
    <button type="submit">
        registration
    </button>
</s:form>
</body>
</html>