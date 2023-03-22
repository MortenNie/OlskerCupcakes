<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Update balance
    </jsp:attribute>

    <jsp:attribute name="footer">
        Update balance page
    </jsp:attribute>

    <jsp:body>

        <form method="post" action="updatebalance">
            <label for="username"> Username  </label>
            <input type="text" id="username" readonly name="username" value="${requestScope.user.username}"/></br>
            <label for name="balance"> Balance </label>
            <input type="text" id="balance" name="balance" value="${requestScope.user.balance}"/> </br>
            <input type="submit" value="updatebalance"/>



        </form>

      

    </jsp:body>

</t:pagetemplate>