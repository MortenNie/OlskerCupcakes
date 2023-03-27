<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
            Order details for all
    </jsp:attribute>

    <jsp:attribute name="footer">
           Order details Page
    </jsp:attribute>

    <jsp:body>

        <p> List of orders: </p>
        <table class="table table-striped mt-4">
            <h1>Orders</h1>
            <form method="post" >
                <tr>
                    <th>Product Id:</th>
                    <th>chosen Bottoms:</th>
                    <th>chosen Bottom price:</th>
                    <th>chosen Topping: </th>
                    <th>chosen Topping price:</th>
                    <th>quantity</th>
                </tr>

                <c:forEach var="item" items="${requestScope.productList}">


                    <tr>

                        <td>${item.productId} </td>
                        <td>${item.bottoms.bottomsName} </td>
                        <td>${item.bottoms.price} </td>
                        <td>${item.topping.toppingName} </td>
                        <td>${item.topping.price} </td>
                        <td>${item.quantity} </td>



                </tr>

                </c:forEach>
        </table>
        </form>


        <p>Jump back to the <a href="welcome.jsp">Frontpage</a>,


    </jsp:body>
</t:pagetemplate>