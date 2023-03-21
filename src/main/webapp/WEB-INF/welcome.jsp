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
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

        <table class="table table-striped mt-4">
            <h1>change balance for users</h1>
            <form method="post">

                <c:forEach var="item" items="${requestScope.userList}">
                <tr>

                    <td>${item.username} </td>
                    <td>${item.balance} </td>>
                    <td><button name="changebalance" type="submit" value="${item.username}" formaction="changebalance" class=" btn btn-primary"> Change balance </button>

                    </td>

                </tr>

                </c:forEach>
        </table>
        </form>

    </jsp:body>

</t:pagetemplate>