<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Student</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div class="container">
<div style="padding:20px;margin-top:20px; background-color:gray; color:white;">
<c:if test="${student.studId != null }">
	<h4>Update Student Details</h4><hr>
</c:if>

<c:if test="${student.studId == null }">
	<h4>Add New Student</h4><hr>
</c:if>

<form action="addStudent" method="post">
	<c:if test="${student.studId != null }">
		<input type="hidden" name="studId" value='<c:out value="${student.studId }"></c:out>'>
	</c:if>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="name">Name</label>
      <input type="text" class="form-control" name="name" id="name" placeholder="Name" value='<c:out value="${student.name }"></c:out>'>
    </div>
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Email" value='<c:out value="${student.email }"></c:out>'>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="course">Course</label>
      <input type="text" class="form-control" id="course" name="course" value='<c:out value="${student.std }"></c:out>'>
    </div>
    <div class="form-group col-md-3">
      <label for="state">Section</label>
      <input type="text" id="state" class="form-control" name="section" value='<c:out value="A"></c:out>'>
    </div>
  </div>
  <div class="form-group">
    <label for="street">Street</label>
    <input type="text" class="form-control" id="street" name="street"  placeholder="1234 Main St" value='<c:out value="${student.studentAdress.street }"></c:out>'>
  </div>
  <div class="form-group">
    <label for="area">Area</label>
    <input type="text" class="form-control" id="area" placeholder="Apartment, studio, or floor" name="area" value='<c:out value="${student.studentAdress.area }"></c:out>'>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="city">City</label>
      <input type="text" class="form-control" id="city" name="city" value='<c:out value="${student.studentAdress.city }"></c:out>'>
    </div>
    <div class="form-group col-md-4">
      <label for="state">State</label>
      <select id="state" class="form-control" name="state">
        <option selected><c:out value="${student.studentAdress.state }"></c:out></option>
        <option>Maharashtra</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="zip">Zip</label>
      <input type="text" class="form-control" id="zip" name="zip" value='<c:out value="${student.studentAdress.zip }"></c:out>'>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>

</body>
</html>