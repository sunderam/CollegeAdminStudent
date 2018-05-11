<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<jsp:include page="studentmenu.jsp"></jsp:include>
<div class="container">
	<div class="info" style="margin-top:20px; background-color:gray; padding:30px;color:white;border-top-left-radius: 100px;border-top-right-radius: 100px;">
	<h4 class="text-center">Student Information</h4><hr>
		<div class="row">
			<div class="col-md-6 text-center">
				<h5>Basic Information</h5><hr>
				<p>Name : ${studentd.name }</p>
				<p>Email : ${studentd.email }</p>
				<p>Course : ${studentd.std }</p>
				<p>Section : A</p><br>
			</div>
			<div class="col-md-6">
				<h5>Student Information</h5><hr>
				<p>Address </p>
				<p>LandMark : ${studentd.studentAdress.street }</p>
				<p>Area : ${studentd.studentAdress.area }</p>
				<p>city : ${studentd.studentAdress.city }-${studentd.studentAdress.zip }</p>
				<p>State : ${studentd.studentAdress.state }</p>
			</div>
		</div>
	</div>
	<div class="info" style="margin-top:20px; background-color:gray; padding:10px;color:white;">
		<div>
			<h3 class="text-center">Notice Board</h3><hr>
			<p>No Notification</p>
		</div>
	</div>
</div>

</body>
</html>