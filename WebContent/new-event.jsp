<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Create a new event</title>
</head>
<body>
	<form action="createNewEventServlet" method="post">
		Event Name: 
			<input type="text" name="eventName"><br /> 
		Event date: 
			<input type="text" name="month" placeholder="mm" size="2">
			<input type="text" name="day" placeholder="dd" size="2">, 
			<input type="text" name="year" placeholder="yyyy" size="4">
		Staff Name:
			<input type="text" name="staffName"><br />
		Available Staff:<br/> <select name="allStaffToAdd" multiple size="12">
			<c:forEach items="${requestScope.allStaff}" var="currentstaff">
			<option value="${currentstaff.id}">${currentstaff.event} | ${currentstaff.staff}</option>
			</c:forEach>
		</select>
		<br/> 
		<input type="submit" value="Create Event and Add Staff">
	</form>
	<a href="index.html">Go add new staff instead.</a>
</body>
</html>