<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Customers</title>
<link type="text/css" href="css/tables.css" rel="stylesheet" />
</head>
<body>

<h1>List of Customers</h1>
    <c:forEach items="${customers}" var="customer">
     	<h2>${customer.cId} ${customer.cName}</h2>   
     	<p>Loan Period = ${customer.loanPeriod}</p> 
     	<h3>${customer.cName}'s Loans</h3>      	
     	<table>
		  <tr>
			   <th>Loan ID</th>
			   <th>Book ID</th>
			   <th>Title</th>
			   <th>Author</th>
		   </tr>
		   
		   <c:forEach items="${customer.loans}" var="loan">
		   	<tr>
	        	<td>${loan.lid}</td> 
	        	<td>${loan.book.bid}</td> 
	        	<td>${loan.book.title}</td> 
	        	<td>${loan.book.author}</td> 
	      	</tr>
		  </c:forEach>
  	</table>       
    </c:forEach>
<a href="/">Home</a>
<a href="/showBooks">List Books</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/logout">Logout</a>

</body>
</html>