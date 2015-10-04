<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>QUEST</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/background.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/fonts.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/panel.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/button.css"/>
</head>
<body>
<c:url var="tooltipURL" value="${tooltipURL}"/>
<div class="panelGridCenter">
    <div class="tittle">
        Завдання № ${questNumber} <br>
        "${name}" <br>
    </div>

    <div class="toolTip">
        ${tooltipInfo} <br>
    </div>

    <input type="button" class="button"
           value="Підказка"
           onclick="window.location.href='${tooltipURL}'"
            <c:if test="${tooltipButtonActive == false}">
                <c:out value="disabled='disabled'"/>
            </c:if>">
</div>
</body>
</html>