<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Your shopping cart:
    </jsp:attribute>

    <jsp:attribute name="footer">
        Shopping cart
    </jsp:attribute>

    <jsp:body>
        <form method="post" >
        <table class="table table-striped mt-4">

            <c:forEach var="s" items="${sessionScope.shoppingcart}">
                <tr>
                    <td>${s.products}</td>
                    <td> ${s.totalPrice} </td>

                </tr>

            </c:forEach>
        </table>
        </form>





    </jsp:body>

</t:pagetemplate>