<%--
  Created by IntelliJ IDEA.
  User: taker
  Date: 13.10.2020
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>book List</h1>
<ul>
    <c:forEach items="${books}" var="book">
        <li>
            <h4>${book.title}</h4>
            <p>publisher: ${book.publishers.name}</p>
            <p>rating: ${book.rating}</p>
            <p>
                <c:forEach items="${book.authors}" var="author">
                author: ${author.firstName} ${author.lastName}
            </c:forEach>
            </p>
        </li>
    </c:forEach>
</ul>
</body>
</html>
