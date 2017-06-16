<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Time-management: Your Appointments</title>

    <link rel="stylesheet" href="/fonts/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/style.css" type="text/css">
</head>

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
                <%--<li class=""><a href="/contact">Contact</a></li>--%>
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
                            <li class=""><a href="/appointments">My appointments</a></li>
                            <li class=""><a href="/logout">Log out</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div class="index_content">
    <div class="selector_wrapper">
        <h3 id="timetableHeader">Your future appointments</h3>
        <table id="timetable">
            <tbody>
            <tr>
                <th>Name</th>
                <th>Specialization</th>
                <th>Date</th>
                <th>Time</th>
                <th>Place</th>
                <th>Room</th>
                <th>Notes</th>
                <th></th>
            </tr>
            <c:forEach items="${appointments}" var="app">
                <tr>
                    <td>${app.specialist.user.fullName}</td>
                    <td>${app.specialist.specialization}</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" type="time" value="${app.dateAndTime}"/></td>
                    <td><fmt:formatDate pattern="HH:mm" type="time" value="${app.dateAndTime}"/></td>
                    <td>${app.specialist.department.organisation.address}</td>
                    <td>${app.specialist.timetable.getSpecificDayTimetable(app.dateAndTime).place}</td>
                    <td>${app.specialist.timetable.getSpecificDayTimetable(app.dateAndTime).notes}</td>
                    <form action="/cancel" method="post" id="cancelForm${app.id}">
                        <input type="text" hidden value="${app.id}" name="appointmentId">
                        <td onclick="document.getElementById('cancelForm${app.id}').submit();">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<title>Bootstrap Example</title>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container">--%>
    <%--<h2>Carousel Example</h2>--%>
    <%--<div id="myCarousel" class="carousel slide" data-ride="carousel">--%>
        <%--<!-- Indicators -->--%>
        <%--<ol class="carousel-indicators">--%>
            <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
        <%--</ol>--%>

        <%--<!-- Wrapper for slides -->--%>
        <%--<div class="carousel-inner">--%>
            <%--<div class="item active">--%>
                <%--<img src="la.jpg" alt="Los Angeles" style="width:100%;">--%>
            <%--</div>--%>

            <%--<div class="item">--%>
                <%--<img src="chicago.jpg" alt="Chicago" style="width:100%;">--%>
            <%--</div>--%>

            <%--<div class="item">--%>
                <%--<img src="ny.jpg" alt="New york" style="width:100%;">--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<!-- Left and right controls -->--%>
        <%--<a class="left carousel-control" href="#myCarousel" data-slide="prev">--%>
            <%--<span class="glyphicon glyphicon-chevron-left"></span>--%>
            <%--<span class="sr-only">Previous</span>--%>
        <%--</a>--%>
        <%--<a class="right carousel-control" href="#myCarousel" data-slide="next">--%>
            <%--<span class="glyphicon glyphicon-chevron-right"></span>--%>
            <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
    <%--</div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
