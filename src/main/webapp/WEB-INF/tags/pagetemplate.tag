<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <a class="navbar-brand" href="index.jsp">
                        <img src="${pageContext.request.contextPath}/images/Olsker.png" width="100%" class="img-fluid"/>
                    </a>
                </div>
                <div class="col-12">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavAltMarkup"
                            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="d-flex justify-content-start">
                        <c:if test="${sessionScope.user != null}">
                            <p>${sessionScope.user.username}</p>
                        </c:if>
                    </div>

                    <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                        <div class="navbar-nav">

                            <c:if test="${sessionScope.user == null }">
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/index.jsp">&#127968; Home</a>
                            </c:if>
                            <c:if test="${sessionScope.user != null }">
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login">&#127968; Home</a>
                            </c:if>

                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/ordercupcake">&#129473; Order cupcakes</a>
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/shoppingcart.jsp">&#128722; Shopping cart</a>
                            <c:if test="${sessionScope.user == null }">
                                <a class="nav-item nav-link"
                                   href="${pageContext.request.contextPath}/login.jsp">&#128275; Login</a>
                            </c:if>
                            <c:if test="${sessionScope.user != null }">
                                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">&#128274; Log
                                    out</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <h1>
        <jsp:invoke fragment="header"/>
    </h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container mt-3">
    <hr/>
    <div class="row">
        <div class="col-5">
            &copy; 1973 Olsker Cupcakes<br/>
            Bornholm, Danmark
        </div>
        <div class="col-5">
            Rønnevej 39B<br/>
            3770 Allinge
            <br/>
        </div>
        <div class="col">
            Olsker's<br/>
            Bedste Cupcakes<br/>
            &zwnj;
        </div>
    </div>

</div>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>