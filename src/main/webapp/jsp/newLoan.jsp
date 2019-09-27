<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Loan</title>
</head>
<body>

	<h1>New Loan</h1>
	<form:form modelAttribute="loanAdded">
		<table>
		  <tr>
		  	<td>Customer ID:</td>
		  	<td> <form:input path="cust.cId" /> <form:errors path="cust.cId"/>${error}</td>
		  </tr>
		  <tr>
		  	<td>Book ID:</td>
		  	<td> <form:input path="book.bid"/> <form:errors path="book.bid"/>${error}</td>
		  </tr>
		</table>
		<input type="submit" value="Loan Book!">
	</form:form>
	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
</body>
</html>