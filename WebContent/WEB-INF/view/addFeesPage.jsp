<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Add Fees</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>


<div>
	<div class="container">
	<div style="background-color:gray; padding:40px; margin-top:80px; color:white;">
		<div class="row">
			<div class="col-md-6">
				<div style="margin-top:20px;">
				<h4>Course & Fees</h4>
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">COURSE</th>
					      <th scope="col">FEES</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${feesList }" var="fees">
								<tr>
									<td>${fees.course }</td>
									<td>${fees.amount }</td>
									<td><a href="addFees?id=<c:out value='${fees.id }' />">delete</a></td>
								</tr>
							</c:forEach>
					  </tbody>
					</table>
				</div>
			</div>
			<div class="col-md-6">
			<div style="margin-top:20px;">
			<h4>Add New Course & Fees</h4><hr>
				<form action="addFees" method="post">
				  <div class="form-group row">
				    <label for="course" class="col-sm-2 col-form-label">Course</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="Course" name="course" placeholder="Add Course">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="amount" class="col-sm-2 col-form-label">Fees</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="amount" name="amount" placeholder="Fees Amount">
				    </div>
				  </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				 </form>
			</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>