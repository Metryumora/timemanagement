<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Timetable</title>
    <link rel="stylesheet" href="/fonts/font-awesome.min.css" type="text/css">
    <%--<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">--%>

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/formSubmitter.js"></script>
    <script src="/js/scroll.js"></script>

    <%--Carousel--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>

<header>
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
                    <sec:authorize access="hasRole('ROLE_SPECIALIST')">
                        <li class=""><a href="/timetable">My timetable</a></li>
                    </sec:authorize>
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">
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
</header>

<div class="index_content">
    <h2 class="tableHeader">My timetable</h2>
    <table class="customTable">
        <tbody>
        <tr>
            <th></th>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesday</th>
            <th>Thursday</th>
            <th>Friday</th>
            <th>Saturday</th>
            <th>Sunday</th>
        </tr>
        <tr>
            <th>
                Working hours
            </th>
            <c:forEach items="${specialist.timetable.timetables}" var="timetable">
                <td>
                    <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.workStarts}"/>
                    -
                    <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.workEnds}"/>
                </td>
            </c:forEach>
        </tr>
        <tr>
            <th>
                Break
            </th>
            </th>
            <c:forEach items="${specialist.timetable.timetables}" var="timetable">
                <td>
                    <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.breakStarts}"/>
                    -
                    <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.breakEnds}"/>
                </td>
            </c:forEach>
        </tr>
        <tr>
            <th>
                Room
            </th>
            <c:forEach items="${specialist.timetable.timetables}" var="timetable">
                <td>
                    ${timetable.place}
                </td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>


<div class="index_content">
    <c:if test="${specialist.getDailyAppointments(now)!=null}">
        <h3 class="tableHeader">Your future appointments</h3>
        <table class="customTable">
            <tbody>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Time</th>
                <th>Place</th>
                <th>Room</th>
                <th>Notes</th>
                <th></th>
            </tr>
            <c:forEach items="${specialist.getDailyAppointments(now)}" var="app">
                <tr>
                    <td>${app.client.fullName}</td>
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
    </c:if>
    <c:if test="${specialist.getDailyAppointments(null)==null}">
        <h3 class="tableHeader">You have no appointments for today.</h3>
    </c:if>
</div>

</body>
</html>