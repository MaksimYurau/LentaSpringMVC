<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2020
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
<%--<%--%>
<%--    String session_user = (String) session.getAttribute("user");--%>
<%--%>--%>

<a href="/post">
    Create post
</a>

<a href="/user/registration">
    Registration
</a>

<a href="/user/authorization">
    Authorization
</a>

<a href="/user/logout">
    Logout
</a>

<c:forEach items="${post}" var="item">
    ${item.title}
    <a href="/post/viewPost?postId=${item.postId}">
        open post
    </a>
</c:forEach>
<%--<% if (session_user != null) { %>--%>
<%--<a href="${pageContext.request.contextPath}">--%>
<%--    Logout--%>
<%--</a>--%>
<%--<% } %>--%>
</body>
</html>
