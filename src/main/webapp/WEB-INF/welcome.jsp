<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the logged in area
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <p>You should be logged in now</p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>

            <form method="post">

            <button formaction="ordercupcake" type="submit" class="align-baseline btn btn-outline-success">Order cupcake</button>
                <button formaction="seeorderhistory" type="submit" class="align-baseline btn btn-outline-success">See order history</button>
            </form>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

        <c:if test="${sessionScope.user.role == 'admin'}">
        <form method="post">

                <button formaction="userlist" type="submit" class="align-baseline btn btn-outline-success"> See User List</button>


        </c:if>


    </jsp:body>

</t:pagetemplate>