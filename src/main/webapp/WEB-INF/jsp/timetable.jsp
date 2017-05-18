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

<select onchange="redirectTo(this.id)" id="select1">
    <option selected hidden></option>
    <c:forEach items="${organisations}" var="org">
        <option value="/departments?org=${org.id}">${org.name}</option>
    </c:forEach>
</select>
<select onchange="redirectTo(this.id)" id="select2">
    <option selected hidden></option>
    <c:forEach items="${departments}" var="dep">
        <option value="/specialists?dep=${dep.id}">${dep.name}</option>
    </c:forEach>
</select>
<table>
    <tbody>
    <c:forEach items="${specialists}" var="spec">
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
        <tr>
            <td>${spec.user.fullName}</td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(0).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(0).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(1).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(1).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(2).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(2).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(3).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(3).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(4).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(4).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(5).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(5).endsWorking}"/></td>
            <td><fmt:formatDate pattern="HH:mm" type="time" value="${spec.timetable.timetables.get(6).startsWorking}"/> -
                <fmt:formatDate pattern="HH:mm" type="time"
                                value="${spec.timetable.timetables.get(6).endsWorking}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table>
    <tr>
        <th>

        </th>
    </tr>
    <tbody>

    </tbody>
</table>
</body>
</html>
