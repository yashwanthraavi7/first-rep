<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action = "IPLController">
		Team Name <input type="text" name = "team_name" value = "${team.teamName}"><br><br>
		City <input type="text" name = "city" value = "${team.city}"><br><br>
		State <input type="text" name = "state" value = "${team.state}"><br><br>
		<input type="hidden" name = "team_id" value = "${team.teamId}">
		<input type="hidden" name = "action" value = "edit">
		<input type="submit" value = "Edit">
	</form>


</body>
</html>