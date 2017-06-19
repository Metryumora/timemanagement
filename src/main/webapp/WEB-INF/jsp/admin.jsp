<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Time-management: Admin Page</title>
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
                    <sec:authorise access="hasRole('ROLE_SPECIALIST')">
                        <li class=""><a href="/timetable">My timetable</a></li>
                    </sec:authorise>
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
<form>
    <div class="index_content">
        <div class="selector_wrapper">
            <form action="/addOrganisation" method="post">
                <div class="selector_wrapper">
                    <div class="selector_description">Name:</div>
                    <input type="text" required name="inputOrganisationName">
                </div>
                <div class="selector_wrapper">
                    <div class="selector_description">Address:</div>
                    <input type="text" required name="inputOrganisationAddress">

                </div>
                <div class="selector_wrapper">
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Add Organisation">
                </div>
            </form>
        </div>
    </div>
    <div class="index_content">
        <div class="selector_wrapper">
            <div class="selector_description">Select organisation:</div>
            <select class="selectorCustom">
                <c:forEach var="org" items="${organisations}">
                    <c:if test="${selectedOrganisation == null}">
                        <option selected disabled></option>
                    </c:if>
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
        <form action="/addDepartment" method="post">
            <div class="selector_wrapper">
                <div class="selector_description">Name:</div>
                <input type="text" required name="inputDepartmentName">
            </div>
            <div class="selector_wrapper">
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Add Department">
            </div>
        </form>
    </div>
    <div class="index_content">
        <div class="selector_wrapper">
            <div class="selector_description">Select department:</div>
            <select class="selectorCustom">
                <c:if test="${selectedDepartment == null}">
                    <option selected disabled></option>
                </c:if>
                <c:forEach items="${departments}" var="dep">
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
            <select class="selectorCustom">
                <c:if test="${selectedSpecialist == null}">
                    <option selected disabled></option>
                </c:if>
                <c:forEach items="${specialists}" var="spec">
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
        </div>
        <form action="/addSpecialist" method="post">
            <div class="selector_wrapper">
                <div class="selector_description">Username:</div>
                <input type="text" required name="inputSpecialistUsername">
            </div>
            <div class="selector_wrapper">
                <div class="selector_description">Specialization:</div>
                <input type="text" required name="inputSpecialistSpecialization">
            </div>
            <div class="selector_wrapper">
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Add Specialist">
            </div>
        </form>
    </div>
</form>
<%--<div class="index_content">--%>
<%--<button class="btn btn-lg btn-primary btn-block">--%>
<%--<nav id="back_to_top">--%>
<%--<div id="header">Back to top</div>--%>
<%--</nav>--%>
<%--</button>--%>
<%--</div>--%>

</body>
</html>