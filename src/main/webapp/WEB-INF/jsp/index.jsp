<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Home</title>

    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <!--This is background-->
    <link rel="stylesheet" media="all"
          href="http://xfer-assets.s3.amazonaws.com/assets/application-183db160aec9c65aee73a1cf65198f90.css"/>

    <!--Popup links-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class=""><a href="/">Time management</a></li>


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        Products <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class=""><a href="/organisations">Organisations</a></li>
                        <li class=""><a href="/departments">Departments</a></li>
                        <li class=""><a href="/specialists">Specialists</a></li>
                    </ul>
                </li>

                <li class=""><a href="/contact">Contact</a></li>

            </ul>

            <!-- right side -->
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${currentUser!=null}">
                        Welcome, ${currentUser.fullName}!
                        <li>
                            <a href="/logout">Log out</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/login">Log in</a>
                        </li>
                        <li>
                            <a href="/registration">Sign up</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>

    </div>
</nav>
<!-- Content    --->

<div class="index_content">
    <div class="central">
    </div>
</div>
</body>
</html>