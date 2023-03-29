<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         list of cupcake combinations
    </jsp:attribute>

    <jsp:attribute name="footer">
        list of cupcake combinations page
    </jsp:attribute>

    <jsp:body>
        <h1> toppings </h1>

        <style></style>
        <form method="post" >
            <table class="table table-hover mt-4">

            <c:forEach var="s" items="${requestScope.alltoppings}">
                <tr>
                    <td><input type="radio" value="${s.toppingName}" id="toppingsChoice" name="toppings" /> ${s.toppingName} </td>
                    <td>${s.price} kr. </td>
                    </td>
                </tr>

              </c:forEach>

            </table>
        <h1> Bottoms </h1>
            <table class="table table-hover mt-4">

                <c:forEach var="t" items="${requestScope.allbottoms}">
                    <tr>
                        <td> <input type="radio" value="${t.bottomsName}" id="bottomsChoice" name="bottoms" /> ${t.bottomsName} </td>
                        <td>${t.price} kr. </td>
                    </tr>

                </c:forEach>


            </table>
            <label for="quantity">Quantity (between 1 and 5):</label>
            <input type="number" id="quantity" name="quantity" min="1" max="5">


            <div class="container mt-3">
            <button name="completecupcake" formaction="completecupcake" type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>

       <form method="post">
           <div class="container mt-3">
           <button formaction="seeshoppingcart" name="seeshoppingcart" type="submit" class="btn btn-secondary">Go to Shoppingcart</button>
           </div>
       </form>
    </jsp:body>

</t:pagetemplate>