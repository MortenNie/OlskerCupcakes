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
            <form >
                <input id="newitem" class="d-inline form-control w-50" type="text" name="newitem" placeholder="Enter new item"/>
                <button formaction="additem" type="submit" class="align-baseline btn btn-outline-success">Add</button>

                <c:forEach var="item" items="${requestScope.userList}">
                <tr>

                    <td>${item.username} </td>
                    <td>${item.balance} </td>>



                </tr>

                </c:forEach>
        </table>
        </form>


        <p>Jump back to the <a href="index.jsp">Frontpage</a>,


    </jsp:body>
</t:pagetemplate>