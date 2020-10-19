<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2020
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
${post.title}
${post.description}

<form action = "/post/like" method="post">
    <input type="hidden" name="postId" value="${post.postId}">
    ${like}
    <button type = "submit" >
Likes
    </button>
</form>

<form action="/post/dislike" method="post">
    <input type="hidden" name="postId" value="${post.postId}">
    ${dislike}
    <button type = "submit" >
        Dislikes
    </button>
</form>

<c:forEach items = "${comments}" var="comment">
    ${comment.description}
</c:forEach>

<form action="/comment/save" method="post">
    <input type="hidden" name="postId" value="${post.postId}">
    <input type="text" name="description">
    <br>
    <button type="submit">
        save comment
    </button>
</form>
</body>
</html>
