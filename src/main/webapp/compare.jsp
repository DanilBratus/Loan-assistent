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
<h2>Подходящие заявки на кредит:</h2>
<center>
<h4>Выберите подходящие вам условия банка и отправьте на рассмотрение.<br>
    Если список условий банка отсутствует, вернитесь к оформлению заявки.</h4><hr>
</center>

<form action="/decision/approve" method="post">

<c:forEach items="${compareList}" var="compareList">
    Банк: ${compareList.bankName} <br>
    Сумма кредита: ${compareList.amountCredit} <br>
    Ставка кредита: ${compareList.rateCredit} <br>
    Срок кредита: ${compareList.termCredit}

    <input type="checkbox" name="bankName" value=${compareList.bankName}><br>
</c:forEach>
<c:if test ="${compareList.size() != 0}">
    <button type="submit">Отправить</button><hr>
</c:if>
</form>
<form action="/request">
    <button type="submit">Составить заявку</button>
</form>
</body>
</html>