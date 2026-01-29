<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DPN</title>
</head>
<body>
<h1>Change Money</h1>
<form action="changeMoney" method="post">
    <label>Amount:</label>
    <input type="number" step="0.01" name="amount" required><br>
    <label>Rate:</label>
    <input type="number" step="0.01" name="rate" required><br>
    <label>Type:</label>
    <select name="type">
        <option value="UsdToVnd">USD-VND</option>
        <option value="VndToUsd">VND-USD</option>
    </select><br>
    <button type="submit">Change</button>
    <c:if test="${not empty message}">
<h2>Result:</h2>
        <p><strong>${message}</strong></p>
    </c:if>
</form>
</body>
</html>