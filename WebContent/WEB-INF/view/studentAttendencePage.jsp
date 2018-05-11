<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendence</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>


<div class="container">
	<div style="margin:80px auto;width:500px; background-color:gray; padding:40px;color:white">
		<h1>Student Attendence</h1>
		<h2>${msg }</h2>
		<form action="attendence" method="post">
			<div class="form-group">
				<label for="id">Student ID</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="Enter student ID">
			</div>
			<div class="form-group">
				<label for="id">Student ID</label>
				<select id="id" name="presence" class="form-control">
					<option selected=selected>Present/Absent</option>
					<option>P</option>
					<option>A</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</div>

</body>
</html>