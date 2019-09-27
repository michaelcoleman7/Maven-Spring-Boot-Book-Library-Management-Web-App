<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Loan</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Delete a Loan</h1>
<form:form modelAttribute="loanToDelete">
	<table>
	  <tr>
	  	<td>Loan ID:</td>
	  	<td> <form:input path="lid" /></td>
	  </tr>
	</table>
	<input type="submit" value="Delete">
</form:form>

<a href="/">Home</a>
<a href="/showBooks">List Books</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loan</a>
<a href="/newLoan">New Loan</a>

</body>
</html>