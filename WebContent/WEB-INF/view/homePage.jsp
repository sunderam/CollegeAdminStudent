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
<title>Homepage</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
	<div class="container">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>	
			</li>
		</ul>
	</div>
	</div>
	</nav>
	<div class="container">
		<div style="margin-top:80px;">
			<div class="row">
				<div class="col-md-6">
					<h4 class="text-center">Heading 1</h4><hr>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis a erat ante. Class aptent taciti 
					sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec porttitor ipsum eget
					 euismod facilisis. Nunc at nulla eget turpis consequat pellentesque. Duis in libero et diam interdum 
					 dignissim sed vel turpis. Nam vitae velit egestas, aliquet tellus vel, cursus mi. Mauris tristique
					  nec enim ut fringilla. Fusce ultrices odio ipsum, vitae bibendum nulla vehicula et. Nam accumsan 
					  ante in accumsan volutpat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames
					  ac turpis egestas. Aliquam gravida nulla lectus, vitae dictum nisl varius ornare.</p>
				</div>
				<div class="col-md-6">
					<h4 class="text-center">Heading 2</h4><hr>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis a erat ante. Class aptent taciti 
					sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec porttitor ipsum eget
					 euismod facilisis. Nunc at nulla eget turpis consequat pellentesque. Duis in libero et diam interdum 
					 dignissim sed vel turpis. Nam vitae velit egestas, aliquet tellus vel, cursus mi. Mauris tristique
					  nec enim ut fringilla. Fusce ultrices odio ipsum, vitae bibendum nulla vehicula et. Nam accumsan 
					  ante in accumsan volutpat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames
					  ac turpis egestas. Aliquam gravida nulla lectus, vitae dictum nisl varius ornare.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div style="width:1200px;position:absolute; bottom:0px;padding-left:500px; background-color:gray;">
			<jsp:include page="footer.jsp"></jsp:include>		
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