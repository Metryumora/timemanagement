<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Home</title>
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
                    <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                        <%--<li class=""><a href="/admin">Administration</a></li>--%>
                    <%--</sec:authorize>--%>
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
    <h2>Welcome to Time Management App :)</h2>
    <c:if test="${currentUser==null}">
        <h4>Please, <a href="/login">log in</a> or <a href="/registration">sign up</a> to arrange an appointment</h4>
    </c:if>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="/images/img_1.png" alt="Slide 1" style="width:100%;">
            </div>

            <div class="item">
                <img src="/images/img_2.jpg" alt="Slide 2" style="width:100%;">
            </div>

            <div class="item">
                <img src="/images/img_3.jpg" alt="Slide 3" style="width:100%;">
            </div>

            <div class="item">
                <img src="/images/img_4.jpg" alt="Slide 4" style="width:100%;">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div class="index_content">
    <div id="formSelect">
        <form name="formSelectors" action="" method="post">
            <div class="selector_wrapper">
                <div class="selector_description">Select organisation:</div>
                <select name="selectedOrganisation" onchange="submitForm(1)" class="selectorCustom">
                    <c:if test="${selectedOrganisation == null}">
                        <option selected disabled></option>
                    </c:if>
                    <c:forEach items="${organisations}" varStatus="loop" var="org">
                        <option
                                value="${org.id}"
                                <c:if test="${org.id == selectedOrganisation}">
                                    selected
                                </c:if>
                        >
                                ${org.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="selector_wrapper">
                <div class="selector_description">Select department:</div>
                <select name="selectedDepartment" onchange="submitForm(2)" class="selectorCustom">
                    <c:if test="${selectedDepartment == null}">
                        <option selected disabled></option>
                    </c:if>
                    <c:forEach items="${departments}" varStatus="loop" var="dep">
                        <option
                                value="${dep.id}"
                                <c:if test="${dep.id == selectedDepartment}">
                                    selected
                                </c:if>
                        >
                                ${dep.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="selector_wrapper">
                <div class="selector_description">Select specialist:</div>
                <select name="selectedSpecialist" onchange="submitForm(3)" class="selectorCustom">
                    <c:if test="${selectedSpecialist == null}">
                        <option selected disabled></option>
                    </c:if>
                    <c:forEach items="${specialists}" varStatus="loop" var="spec">
                        <option
                                value="${spec.id}"
                                <c:if test="${spec.id == selectedSpecialist}">
                                    selected
                                </c:if>
                        >
                                ${spec.user.fullName}
                        </option>
                    </c:forEach>
                </select>
                <input hidden type="text" name="${fieldName}" value="${appointmentDate}">
            </div>
            <c:if test="${appointmentsSend}">
                <div id="appointments">
                    <div class="selector_wrapper">
                        Address: ${organisations.get(0).address}
                    </div>
                    <div class="selector_wrapper">
                        <c:if test="${appointmentPlace!=null}">
                            Room: ${appointmentPlace}
                        </c:if>
                    </div>
                    <div class="selector_wrapper">
                        <div class="selector_description">Select date:</div>
                        <input type="date" name="appointmentDate" class="selectorCustom" value="${appointmentDate}"
                               onchange="submitForm(3)">
                    </div>
                    <div class="selector_wrapper">
                        <c:if test="${!empty appointments}">
                            <div class="selector_description">Select time:</div>
                            <select title="Select date:" class="selectorCustom" id="selectorCustomWidth"
                                    name="appointmentTime">
                                <c:forEach items="${appointments}" var="appointment">
                                    <c:if test="${appointment.client == null}">
                                        <option>
                                            <fmt:formatDate pattern="HH:mm" type="time"
                                                            value="${appointment.dateAndTime}"/>
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </c:if>
                        <c:if test="${empty appointments}">
                            <p>${specialist.user.fullName} has a weekend today or is busy for whole day already.
                                Please, check timetable and look for the other day.
                            </p>
                        </c:if>
                    </div>
                </div>
                <c:if test="${currentUser!=null && !empty appointments}">
                    <div class="selector_wrapper">
                        <button class="btn btn-lg btn-primary btn-block" onclick="submitForm(4)">Arrange</button>
                    </div>
                </c:if>
            </c:if>
        </form>
    </div>

    <c:if test="${!empty monthlyAppointments && empty appointments}">
        <div class="selector_wrapper">
            <table class="customTable">
                <tbody>
                <tr>
                    <th>Mon</th>
                    <th>Tue</th>
                    <th>Wed</th>
                    <th>Thu</th>
                    <th>Fri</th>
                    <th>Sat</th>
                    <th>Sun</th>
                </tr>
                <c:forEach items="${monthlyAppointments}" var="weekApps">
                    <tr>
                        <c:forEach items="${weekApps}" var="dayApps">
                            <c:choose>
                                <c:when test="${dayApps.status=='red'}">
                                    <td class="redCell">${dayApps.day}</td>
                                </c:when>
                                <c:when test="${dayApps.status=='yellow'}">
                                    <td class="yellowCell">${dayApps.day}</td>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${!empty specialists && empty appointments}">
        <div class="selector_wrapper">
            <h3 class="tableHeader">Timetable</h3>
            <table class="customTable">
                <tbody>
                <tr>
                    <th>Name</th>
                    <th>Specialization</th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                    <th>Saturday</th>
                    <th>Sunday</th>
                </tr>
                <c:forEach items="${specialists}" var="spec">
                    <tr>
                        <td>${spec.user.fullName}</td>
                        <td>${spec.specialization}</td>
                        <c:forEach items="${spec.timetable.timetables}" var="timetable">
                            <td>
                                <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.workStarts}"/>
                                -
                                <fmt:formatDate pattern="HH:mm" type="time" value="${timetable.workEnds}"/>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>

<div class="index_content">
    <button class="btn btn-lg btn-primary btn-block">
        <nav id="back_to_top">
            <div id="header">Back to top</div>
        </nav>
    </button>
</div>

</body>
</html>