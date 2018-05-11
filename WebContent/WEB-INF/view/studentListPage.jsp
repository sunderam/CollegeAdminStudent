<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
a:link {
    text-decoration: none;
}
#del{
	color:Tomato;
	text-decoration: none;
}
#up{
	color:DodgerBlue;
	text-decoration: none;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>


<div class="container">
<div style="background-color:gray;color:white;padding:20px;margin-top:20px;">
<h4>All Student List</h4>
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">EMAIL</th>
      <th scope="col">ADDRESS</th>
      <th scope="col">COURSE</th>
      <th scope="col">SECTION</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${studentList}" var="student">
    <tr>
      <th scope="row">${student.studId }</th>
      <td>${student.name }</td>
				<td>${student.email }</td>
				<td>${student.studentAdress.street }, 
				${student.studentAdress.area }, 
				${student.studentAdress.city }-
				${student.studentAdress.zip }</td>
				<td>${student.std }</td>
				<td>A</td>
				<td><a id="up" href="addStudent?action=update&id=<c:out value='${student.studId }'/> ">Update</a></td>
				<td><a id="del" href="addStudent?action=delete&id=<c:out value='${student.studId }'/>">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>