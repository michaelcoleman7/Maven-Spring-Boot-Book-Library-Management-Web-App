<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>

<h1>Add a Customer</h1>
<form:form modelAttribute="custAdded">
	<table>
	  <tr>
	  	<td>Cust Name:</td>
	  	<td> <form:input path="cName" /> <form:errors path="cName">May not be empty</form:errors></td>
	  </tr>
	  <tr>
	  	<td>Loan Period (days):</td>
	  	<td> <form:input path="loanPeriod"/> <form:errors path="loanPeriod">Must be greater or equal to 1</form:errors></td>
	  </tr>
	</table>
	<input type="submit" value="Add">
</form:form>

<a href="/">Home</a>
<a href="/addBook">Add Book</a>
<a href="/addCustomer">Add Customers</a>
<a href="/newLoan">New Loan</a>
</body>
</html>