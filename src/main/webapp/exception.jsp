<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <meta charset= "UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Loan assistant</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
    <h2>Пользователь с таким логином и паролем уже существует</h2>
    <h4>Пройдите регистрацию заново или войдите в систему, если вы регистрировались ранее</h4><hr>
<br>
<form action="/registration">
    <button type="submit">Регистрация</button>
</form>
<form action="/request">
    <button type="submit">Войти</button>
</form>
</br>
</center>
</body>
</html>