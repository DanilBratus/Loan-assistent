<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html xmlns:th="https://www.thymeleaf.org">
<head th:include="layout :: head(title=~{::title},links=~{})">
    <meta charset= "UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Loan assistant</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<body th:include="layout :: body" th:with="content=~{::content}">
    <div th:fragment="content">
        <form name="f" th:action="@{/login}" method="post">
            <h2>Авторизация</h2><hr>
            <input required = "required" type="text" id="username" name="username" placeholder="Введите логин"/>
            <input required = "required" type="password" id="password" name="password" placeholder="Введите пароль"/>
            <div class="form-actions">
                <button type="submit" class="btn">Войти</button>
            </div>
        </form>
        <form id ="form" class="topBefore" action="/hello">
              <br><button id="submit" type="submit">Назад</button>
        </form>
    </div>
</body>
</html>