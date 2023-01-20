<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset= "UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Loan assistant</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Решения банков:</h2>
<c:forEach items="${decision}" var="decision">
    ${decision} <hr>
</c:forEach>
<center>
<form action="/loan_assistant">
    <button type="submit">Главное меню</button>
</form>
</center>
</body>
</html>