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
        <form method="post" >
            <table class="table table-striped mt-4">

            <c:forEach var="s" items="${requestScope.alltoppings}">
                <tr>
                    <td><input type="radio" id="toppingsChoice" name="toppings" /> ${s.toppingName} </td>


                    <td>${s.price} kr. </td>



                </tr>

              </c:forEach>
            </table>
        <h1> Bottoms </h1>
            <table class="table table-striped mt-4">

                <c:forEach var="t" items="${requestScope.allbottoms}">
                    <tr>
                        <td><input type="radio" id="bottomsChoice" name="bottoms" /> ${t.bottomsName}   </td>
                        <td>${t.price} kr. </td>>

                    </tr>

                </c:forEach>
            </table>
            <button name="completecupcake" type="submit">Submit</button>
        </form>
      
       <form method="post">

           <button formaction="seeshoppingcart" name="seeshoppingcart" type="submit">Go to Shoppingcart</button>

       </form>
    </jsp:body>

</t:pagetemplate>