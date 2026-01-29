<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dpnbh
  Date: 10/01/2026
  Time: 7:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Từ điển Anh – Việt</h2>

<form action="Dictionary" method="get">
    <input type="text" name="english" placeholder="Nhập từ tiếng Anh" required>
    <button type="submit">Tra cứu</button>
</form>

<br>

<c:if test="${not empty result}">
    <p><b>Từ:</b> ${english}</p>
    <p><b>Nghĩa:</b> ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
