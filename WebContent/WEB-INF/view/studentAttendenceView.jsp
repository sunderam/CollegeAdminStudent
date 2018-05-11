<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>View Attendence</title>
</head>
<body>
<jsp:include page="studentmenu.jsp"></jsp:include>
<div class="container">
	<div style="margin:80px auto;padding:20px; width:500px;background-color:gray;color:white;border-top-left-radius: 100px;">
		<h4 class="text-center">Attendence</h4><hr>
		<form action="StudentAttendence" method="post">
			<div class="row">
					<div class="col-md-6">
						<div class=form-group>
							<label for="from">From</label>
							<select name="from" class="form-control">
								<option selected="selected">2018-01-01</option>
								<option>2018-02-01</option>
								<option>2018-03-01</option>
								<option>2018-04-01</option>
								<option>2018-05-01</option>
								<option>2018-06-01</option>
								<option>2018-07-01</option>
								<option>2018-08-01</option>
								<option>2018-09-01</option>
								<option>2018-10-01</option>
								<option>2018-11-01</option>
								<option>2018-12-01</option>
								
							</select>
						</div>
					</div>
					<div class="col-md-6">
						<div class=form-group>
							<label for="to">To</label>
							<select name="to" class="form-control">
								<option selected="selected">2018-01-31</option>
								<option>2018-02-28</option>
								<option>2018-03-30</option>
								<option>2018-04-31</option>
								<option>2018-05-30</option>
								<option>2018-06-30</option>
								<option>2018-07-31</option>
								<option>2018-08-30</option>
								<option>2018-09-30</option>
								<option>2018-10-30</option>
								<option>2018-11-31</option>
								<option>2018-12-31</option>
							</select>
						</div>
					</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary btn-block">Get</button>
				</div>
			</div>
		</form><hr>
		<div class=row>
			<div class="col-md-12">
				<table class="table table-striped">
				  <thead>
				    <tr>
				
				      <th scope="col">Date</th>
				      <th scope="col">Attendence</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${attendence }" var="attendence">
				    <tr>
				     
				      <td>${attendence.dateOfAttendence }</td>
				      <td>${attendence.presence }</td>
				    </tr>
				    <tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>