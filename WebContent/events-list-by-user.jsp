<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event List e</title>
</head>
<body>
	<form method="post" action="">
		<table>
			<c:forEach items =" ${request Scope.allStaff}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value=" ${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Staff Name: ${currentlist.Staff.staffName}</td>
				</tr>
				<tr>
					<td colspan="3">Staff Occupation: ${currentlist.Staff.staffOccupation}</td></tr>
					<c:forEach var = "listVal" items = "${currentlist.staffOccupation}">
					<tr><td></td><td colspan="3"> 
						${listVal.Events}, ${listVal.Staff}
						</td>
						</c:forEach>
					</c:forEach>
				</table>
				<input type ="submit" value ="edit" name="editItem">
				<input type ="submit" value ="delete" name="deleteItem">
				<input type="submit" value ="add" name ="addItem">
			</form>
			<a href="addItemsForListServlet">Create a new Event</a>
			<a href="index.html">Insert a new Staff member</a>
		</body>
	</html>
</tr>