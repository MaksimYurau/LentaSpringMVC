<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CreatePost</title>
</head>
<body>

<d:form action="/post" modelAttribute="post" method="post">

    <d:input type="text" path="title"/>
    <br>
    title
    <d:errors path="title"/>
    <br>
    <d:input type="text" path="description"/>
    <br>
    description
    <d:errors path="description"/>
    <br>
    <button type="submit">
        save
    </button>

</d:form>

</body>
</html>
