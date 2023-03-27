<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
            Order history for all
    </jsp:attribute>

    <jsp:attribute name="footer">
           Order history Page
    </jsp:attribute>

    <jsp:body>

        <p> List of orders: </p>
        <table class="table table-striped mt-4">
            <h1>Orders</h1>
            <form method="post" >
                <tr>
                    <th>username:</th>
                    <th>order Id:</th>
                    <th>date:</th>
                </tr>

                <c:forEach var="item" items="${requestScope.orderList}">


                    <tr>

                    <td>${item.username} </td>
                    <td>${item.orderId} </td>
                    <td>${item.date} </td>
                    <td><button name="orderdetails" type="submit" value="${item.orderId}" formaction="orderdetails" class=" btn btn-primary"> See order details </button></td>


                </tr>

                </c:forEach>
        </table>
        </form>


        <p>Jump back to the <a href="welcome.jsp">Frontpage</a>,


    </jsp:body>
</t:pagetemplate>