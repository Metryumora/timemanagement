<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Home</title>

    <%--<link rel="stylesheet" href="/static/css/bootstrap/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="/static/css/style.css">--%>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <!--This is background-->
    <link rel="stylesheet" media="all"
          href="http://xfer-assets.s3.amazonaws.com/assets/application-183db160aec9c65aee73a1cf65198f90.css"/>

    <!--This is JS for header-->
    <!--<script src="//xfer-assets.s3.amazonaws.com/assets/application-653e9726a10c9e317ffaaf9402ad69b2.js"></script>-->
    <!--<script src="../js/jQuery JavaScript Library v1.12.1.js"></script>-->

    <!--Popup links-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/style.css">
    <link>

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
                <c:if test="${currentUser==null}">
                    <li>
                        <a href="/login">Log in</a>
                    </li>
                    <li>
                        <a href="/registration">Sign up</a>
                    </li>
                </c:if>
                <c:if test="${currentUser!=null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            Welcome, ${currentUser.fullName}! <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li class=""><a href="/#">Settings</a></li>
                            <li class=""><a href="/#">azaza</a></li>
                            <li class=""><a href="/logout">Log out</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="/logout">Log out</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<!-- Content    --->

<div class="index_content">
    <h2>Welcome to Time Management App :)</h2>
    <h4>Please, <a href="/login">log in</a> or <a href="/registration">sign up</a> to arrange to appointment</h4>

    <form id="form_select">
        <div class="selector_wrapper">
            <div class="selector_description">Select organisation:</div>
            <select name="faculty" class="selector" onchange="do_something();">
                <option value="0"> One</option>
            </select>
        </div>

        <div class="selector_wrapper">
            <div class="selector_description">Select department:</div>
            <select name="faculty" class="selector" onchange="do_something();">
                <option value="0"> One</option>
            </select>
        </div>

        <div class="selector_wrapper">
            <div class="selector_description">Select specialist:</div>
            <select name="faculty" class="selector" onchange="do_something();">
                <option value="0"> Oneeeeeeeeeeeeeeeeeeee</option>
            </select>
        </div>

    </form>
</div>
</body>
</html>