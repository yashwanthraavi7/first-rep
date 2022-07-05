<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*"%>
<%@ page import="ipl.beans.Team"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1 align="center">Welcome to IPL</h1>
		<form action="IPLController">
			<table class="table">
				<tr>
					<th></th>
					<th>Team Id</th>
					<th>Team Name</th>
					<th>City</th>
					<th>State</th>
				</tr>

				<c:forEach var="team" items="${allTeams}">
					<tr>
						<td><input type="radio" name="team_id" value="${team.teamId}"></td>
						<td>${team.teamId}</td>
						<td>${team.teamName}</td>
						<td>${team.city}</td>
						<td>${team.state}</td>
					</tr>
				</c:forEach>


			</table>

			<a href="add_team.html" class="btn btn-primary" role="button">Add
				New Team</a> 
			
			<button type="submit" class="btn btn-primary" formaction="IPLController" name = "action" value = "delete">Delete</button>
			<button type="submit" class="btn btn-primary" formaction="IPLController" name = "action" value = "get_team_details">Edit</button>
			
		</form>
	</div>

</body>
</html>