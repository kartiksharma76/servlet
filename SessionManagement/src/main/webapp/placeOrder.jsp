<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JBM Book store</h1>
<h2>Your order has placed successfully</h2>
<br/>
<%session.invalidate(); %>
<br/>
<a href="index.jsp">Go to search page</a>
</body>
</html>