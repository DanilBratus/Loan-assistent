<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <meta charset= "UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <title>Loan assistant</title>
</head>
<body>
<center>
    <h1>Добро пожаловать на сайт по подбору кредита!</h1>
    <h4>Здесь вы можете выбрать подходящий вам кредит и отправить заявку в банк</h4><hr>
    <sec:authorize access="!isAuthenticated()">

<form action="/registration">
    <button type="submit">Регистрация</button>
</form>

<form action="/request">
    <button type="submit">Войти</button>
</form>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

<form action="/logout">
    <button type="submit">Выйти</button>
</form>
</sec:authorize>
</center>
</body>
</html>
