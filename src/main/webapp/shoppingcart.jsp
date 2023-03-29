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

                <c:forEach var="s" items="${sessionScope.shoppingcart.products}">
                    <tr>
                        <td>${s.toString()}</td>
                        <td>
                        <button name="deleteproductfromcart" type="submit" value="${s.productId}" formaction="deleteproductfromcart" class="btn btn-primary"> Delete </button>
                        </td>
                    </tr>


          </c:forEach>
            </table>

            <table class="table table-striped mt-4">



                <tr>
                    <td>Total pris: ${sessionScope.shoppingcart.totalPrice} kr. </td>
                    <td>  </td>

                </tr>


            </table>

            <button type="submit" formaction="confirmorder" value="${sessionScope.shoppingcart.totalPrice}" name="confirmorder">Confirm order </button>

        </form>



    </jsp:body>

</t:pagetemplate>