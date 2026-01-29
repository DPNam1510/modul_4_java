<%--
  Created by IntelliJ IDEA.
  User: dpnbh
  Date: 26/01/2026
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DPN</title>
</head>
<body>
<h1>Máy tính cá nhân</h1>
<form action="calculator" method="get">
    <input type="number" name="num1" placeholder="enter the first number">
    <input type="number" name="num2" placeholder="enter the second number"><br>

    <button name="action" value="sum">Addition(+)</button>
    <button name="action" value="sub">Subtraction(-)</button>
    <button name="action" value="mul">Multiplication(*)</button>
    <button name="action" value="div">Division(/)</button>
</form>
<h3>Result = ${result}</h3>
<c:if test="${not empty mess}">
    <h3>${mess}</h3>
</c:if>
</body>
</html>
