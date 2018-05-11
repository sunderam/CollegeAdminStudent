<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Pay Fees</title>
</head>
<body>
<jsp:include page="studentmenu.jsp"></jsp:include>

<div class="container">
		<div style="margin:60px auto;width:600px; background-color:gray;padding:40px;color:white;border-top-left-radius: 100px;">
		<h4>Course Fees Details</h4><hr>
			<form action="studentFees" method="post">
				<div class="form-group">
					<label for="totalfees">Total Fees</label>
					<input type="text" name="totalfees" id="totalfees" class="form-control" value='<c:out value="${fees.totalFees }"/>' readonly>
				</div>
				<div class="form-group">
					<label for="paidfees">Fees Paid</label>
					<input type="text" name="paidfees" id="totalfees" class="form-control" value='<c:out value="${fees.paidFees }"/>' readonly>
				</div>
				<div class="form-group">
					<label for="ramainingfees">Remaining Fees</label>
					<input type="text" name="remainingfees" id="remainingfees" class="form-control" value='<c:out value="${fees.remainingFees }"/>' readonly>
				</div>
				<div class="form-group">
					<label for="payfees">Amount</label>
					<input type="text" name="payfees" id="payfees" class="form-control" placeholder="Enter Amount To Pay">
				</div>
				<button type="submit" class="btn btn-primary btn-block">Pay</button>
			</form>
		</div>
</div>
</body>
</html>