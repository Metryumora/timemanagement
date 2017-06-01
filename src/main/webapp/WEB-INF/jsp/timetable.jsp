<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Metr_yumora
  Date: 15.05.2017
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/timetable.css">
    <script src="/js/selectorManagement.js"></script>
</head>
<body>
Welcome, ${currentUser.fullName}!

<script src="/js/formSubmitter.js">

</script>

<form name="formSelectors" action="" method="post">
    <select name="selectedOrganisation" onchange="submitForm(1)">
        <c:if test="${selctedOrganisation == null}">
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
    <br>
    <select name="selectedDepartment" onchange="submitForm(2)">
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
    <br>
    <select name="selectedSpecialist" onchange="submitForm(3)">
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
</form>

<c:if test="${!empty specialists}">
    <div id="timetable">
        <table>
            <tr>
                <th>Name</th>
                <th>Monday</th>
                <th>Tuesday</th>
                <th>Wednesday</th>
                <th>Thursday</th>
                <th>Friday</th>
                <th>Saturday</th>
                <th>Sunday</th>
            </tr>
            <tbody>
            <c:forEach items="${specialists}" var="spec">
                <tr>
                    <td>${spec.user.fullName}</td>
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
<c:if test="${!empty appointments}">
    <div id="appointments">
        Specialist's name: ${appointments.get(0).specialist.user.fullName}<br>
        Address: ${appointments.get(0).specialist.department.organisation.address}<br>
        Room: ${appointments.get(0).specialist.timetable.getHodiernalTimetable().place}<br>
        <table>
            <tr>
                <th>Client</th>
                <th>Time</th>
            </tr>

            <tbody>
            <c:forEach items="${appointments}" var="appointment">
                <tr>
                    <td>${appointment.client.fullName}</td>
                    <td><fmt:formatDate pattern="HH:mm" type="time" value="${appointment.dateAndTime}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
</body>
</html>
