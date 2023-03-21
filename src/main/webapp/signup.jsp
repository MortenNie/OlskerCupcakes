<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Sign up
    </jsp:attribute>

    <jsp:attribute name="footer">
        Sign up page.
    </jsp:attribute>

    <jsp:body>

        <form action="signup" method="post">
            username/email: <input type="text" name="username"/><br/><br/>
            Password: <input type="password" name="password"><br/><br/>
            Start balance: <input type="text" name="balance"><br/><br/>

            <button type="submit">Sign up </button>
        </form>

    </jsp:body>

</t:pagetemplate>