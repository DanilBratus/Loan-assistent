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
    <h2>Заявка на кредит:</h2>
    <center><p>Введите данные, для подбора подходящих вам условий банка</p></center>
<hr>

<form id="form" class="topBefore" action="/compare/submit" method="post" modelAttribute="request">

<br>
    <tr>
        <input type="text" placeholder="Введите сумму кредита" name="amountCredit" required>
    </tr>
</br>
<br>
    <tr>
        <input type="text" placeholder="Введите ставку кредита" name="rateCredit" required>
    </tr>
</br>
<br>
    <tr>
        <input type="text" placeholder="Введите срок кредита в месяцах" name="termCredit" required>
    </tr>
</br>
<br>
    <tr>
        <input type="text" placeholder="Фамилия" name="lastName" required>
    </tr>
</br>
<br>
    <tr>
        <input type="text" placeholder="Имя" name="firstName" required>
    </tr>
</br>
<br>
    <tr>
        <input type="text" placeholder="Отчество" name="secondName" required>
    </tr>
</br>
<br>
    <tr>
        <input type="date" name="birthDay" required>
    </tr>
</br>
<br>
    <button id="submit" type="submit">Сравнить</button>
</br>
</form>
</body>
</html>
