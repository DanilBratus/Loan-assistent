<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta charset= "UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Loan assistant</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div>
  <form:form id ="form" class="topBefore" method="POST" action="/registration/save" modelAttribute="user">
    <h2>Регистрация</h2><hr>
    <div>
      <form:input required = "required" type="text" path="login" placeholder="Введите логин"
                  autofocus="true"></form:input>
      <form:errors path="login"></form:errors>
        ${usernameError}
    </div>
    <div>
      <form:input required = "required" type="password" path="password" placeholder="Введите пароль"></form:input>
    </div>
    <button id="submit" type="submit">Зарегистрироваться</button>
  </form:form>
<div>
  <form id ="form" class="topBefore" action="/loan_assistant">
      <br><button id="submit" type="submit">Назад</button>
  </form>
</div>
</div>
</body>
</html>