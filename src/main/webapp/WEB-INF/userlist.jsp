<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
            User List
    </jsp:attribute>

    <jsp:attribute name="footer">
           User List Page
    </jsp:attribute>

    <jsp:body>

        <p> list of users:
        <table class="table table-striped mt-4">
            <h1>Users</h1>
            <form method="post" >


                <c:forEach var="item" items="${requestScope.userList}">
                <tr>

                    <td>${item.username} </td>
                    <td>${item.balance} </td>>
                    <td><button name="changebalance" type="submit" value="${item.username}" formaction="changebalance" class=" btn btn-primary"> Change balance </button></td>
                    <td><button name="orderhistoryforuser" type="submit" value="${item.username}" formaction="orderhistoryforuser" class=" btn btn-primary"> See order history for this user </button></td>

                </tr>

                </c:forEach>
        </table>
        </form>





    </jsp:body>
</t:pagetemplate>