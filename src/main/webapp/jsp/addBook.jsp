<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Add a Book</h1>
<form:form modelAttribute="bookAdded">
	<table>
	  <tr>
	  	<td>Title:</td>
	  	<td> <form:input path="title" /> <form:errors path="title"/></td>
	  <tr>
	  	<td>Author:</td>
	  	<td> <form:input path="author"/> <form:errors path="author"/></td>
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