<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<title>Login</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
.login {
	margin: 40px auto;
	background-color: light-gray;
	padding: 40px;
	width: 400px;
	height: 300px;
}

.login a {
	color: green;
	font-weight: 600;
}

.login a:hover {
	text-decoration: none;
}
</style>

</head>
<body>
	<div class="container">
		<div class="login">
			<h4>Login</h4>
			<p class="float-right">
				Not a User <a href="">Contact Administration</a>
			</p>
			<br>
			<hr>
			<form action="login" method="post">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" name="username" class="form-control"
						placeholder="Username">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control"
						placeholder="Password">
				</div>
				<button id="login" class="btn btn-primary btn-block">Login</button>
			</form>
			<c:if test="${msg != null }">
			 <div class="well bg-info" style="padding:10px; margin-top:20px;color:white;">${msg }</div>
			</c:if>
			<c:if test="${err != null }">
			 <div class="well bg-danger" style="padding:10px; margin-top:20px;color:white;">${err }</div>
			</c:if>
		</div>
	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>